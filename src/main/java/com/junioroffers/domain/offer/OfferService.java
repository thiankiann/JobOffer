package com.junioroffers.domain.offer;


import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class OfferService {
    private final OfferRepository offerRepository;

    OfferResponseDto findOfferById(String id) {

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
