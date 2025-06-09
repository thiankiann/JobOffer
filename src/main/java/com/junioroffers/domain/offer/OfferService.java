package com.junioroffers.domain.offer;


import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.junioroffers.domain.offer.OfferMapper.mapOfferRequestDtoToOffer;
import static com.junioroffers.domain.offer.OfferMapper.mapOfferToOfferResponseDto;

@AllArgsConstructor
class OfferService {
    private final OfferRepository offerRepository;
    private final OfferFetchable offerFetchable;


    OfferResponseDto findOfferById(String id) {

        return offerRepository.findOfferById(id).
                map( (Offer offer) -> mapOfferToOfferResponseDto(offer)
                ).orElseThrow(() -> new OfferNotFoundException("Offer not Found"));
    }

    void saveIfOfferUrlIsNotDuplicated(OfferRequestDto offerRequestDto) {
        Offer offer = mapOfferRequestDtoToOffer(offerRequestDto);
        List<OfferResponseDto> allUnfiltrateedOffers = offerRepository.findAllOffers();

      //  try {
            boolean isUrlDuplicated = offerRepository.isUrlDuplicated(offer.offerUrl());
            if(!(isUrlDuplicated)) {
                saveOffer(offerRequestDto);
            }else {
                throw new DuplicateKeyException("Duplicate Key Exception");
            }
//        } catch (RuntimeException e) {
//            throw new RuntimeException("RuntimeException!!!");
//        }
    }
//    boolean isOfferUrlIsNotDuplicated(OfferRequestDto offerRequestDto) {
//        Offer offer = mapOfferRequestDtoToOffer(offerRequestDto);
//
//        boolean isUrlDuplicated = offerRepository.isUrlDuplicated(offer.offerUrl());
//        if(!(isUrlDuplicated)) {
//           // saveOffer(offerRequestDto);
//            return true ;
//        }else {
//            throw new DuplicateKeyException("Duplicate Key Exception");
//        }
//    }
    OfferResponseDto saveOffer(OfferRequestDto offerRequestDto) {
      //  saveIfOfferUrlIsNotDuplicated(offerRequestDto);
         Offer offer = mapOfferRequestDtoToOffer(offerRequestDto);


            Offer savedoffer = offerRepository.save(offer);
            return mapOfferToOfferResponseDto(savedoffer);

    }
 List<Offer> filterNotExistingOffers(List<Offer> offers){
//     List<Offer> offers = fetchAllOffers();
     return offers.stream()
             .filter(offer -> !offerRepository.isUrlDuplicated(offer.offerUrl()))
             .filter(offer -> !offer.offerUrl().isEmpty())
             .collect(Collectors.toList());
 }

 List<Offer> fetchAllOffersAndSaveIfExist(){
     List<Offer> allOffers = fetchAllOffers();
     List<Offer> offers = filterNotExistingOffers(allOffers);
     try {
         return offerRepository.saveAll(offers);
     } catch (OfferDuplicateException e) {
         throw new OfferSavingException(e.getMessage());
     }
 }

    List<OfferResponseDto> findAllOffers() {
      //  List<OfferResponseDto> AllOffersDto = offerRepository.findAllOffers();
        return offerRepository.findAllOffers();
    }
    private List<Offer> fetchAllOffers() {
        return offerFetchable.fetchAllOffers()
                .stream()
                .map(OfferMapper::mapJobOfferResponseToOffer)
                .collect(Collectors.toList());
    }

}
