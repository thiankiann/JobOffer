package com.junioroffers.domain.offer;


import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class OfferService {
    private final OfferRepository offerRepository;
//    private final OfferMapper offerMapper;
    private final OfferNotFoundException offerNotFoundException;

    OfferResponseDto findOfferById(String id) {
//        Optional<Offer> offerById = offerRepository.findOfferById(id);
//              //  .orElseThrow( () -> (new OfferNotFoundException("Offer Not Found")));
//        OfferResponseDto offerResponseDto = new OfferResponseDto(
//                offerById.get().id(),
//                offerById.get().companyName(),
//                offerById.get().position(),
//                offerById.get().salary(),
//                offerById.get().offerUrl()) ;
//        return offerResponseDto;
//====================================
        return offerRepository.findOfferById(id)
                .map( offer -> new OfferResponseDto(
                                    offer.id(),
                                    offer.companyName(),
                                    offer.position(),
                                    offer.salary(),
                                    offer.offerUrl()
                        )
                ).orElseThrow(() -> new OfferNotFoundException("Offer not Found"));
    }
}
