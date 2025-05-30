package com.junioroffers.domain.offer;


import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.junioroffers.domain.offer.OfferMapper.mapOfferRequestDtoToOffer;
import static com.junioroffers.domain.offer.OfferMapper.mapOfferToOfferResponseDto;

@AllArgsConstructor
class OfferService {
    private OfferRepository offerRepository;
  //  private final OfferFetchable offerFetchable;


    OfferResponseDto findOfferById(String id) {

        return offerRepository.findOfferById(id).
                map( (Offer offer) -> mapOfferToOfferResponseDto(offer)
                ).orElseThrow(() -> new OfferNotFoundException("Offer not Found"));


//        return offerRepository.findOfferById(id)
//                .map( offer -> new OfferResponseDto(
//                                    offer.id(),
//                                    offer.companyName(),
//                                    offer.position(),
//                                    offer.salary(),
//                                    offer.offerUrl()
//                        )
//                ).orElseThrow(() -> new OfferNotFoundException("Offer not Found"));

    }

    void saveIfOfferUrlIsNotDuplicated(OfferRequestDto offerRequestDto) {
        Offer offer = mapOfferRequestDtoToOffer(offerRequestDto);
//        try {
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
    void isOfferUrlIsNotDuplicated(OfferRequestDto offerRequestDto) {
        Offer offer = mapOfferRequestDtoToOffer(offerRequestDto);

        boolean isUrlDuplicated = offerRepository.isUrlDuplicated(offer.offerUrl());
        if(!(isUrlDuplicated)) {
            saveOffer(offerRequestDto);
        }else {
            throw new DuplicateKeyException("Duplicate Key Exception");
        }
    }
    OfferResponseDto saveOffer(OfferRequestDto offerRequestDto) {
      //  saveIfOfferUrlIsNotDuplicated(offerRequestDto);
        final Offer offer = mapOfferRequestDtoToOffer(offerRequestDto);


            Offer savedoffer = offerRepository.save(offer);
            return mapOfferToOfferResponseDto(savedoffer);
////
////        }
//        boolean isUrlDuplicated = offerFetchable.isUrlDuplicated(offer);
//            Offer savedoffer = offerRepository.save(offer);
//            return mapOfferToOfferResponseDto(savedoffer);
//        }else {
//
//        }
    }




    List<OfferResponseDto> findAllOffers() {
      //  List<OfferResponseDto> AllOffersDto = offerRepository.findAllOffers();
        return offerRepository.findAllOffers();
    }
}
