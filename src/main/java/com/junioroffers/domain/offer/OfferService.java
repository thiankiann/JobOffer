package com.junioroffers.domain.offer;


import com.junioroffers.domain.offer.dto.OfferRequestDto;
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

    OfferResponseDto saveOffer(OfferRequestDto offerDto) {
        final Offer offer = Offer.builder()
                .companyName(offerDto.companyName())
                .position(offerDto.position())
                .salary(offerDto.salary())
                .offerUrl(offerDto.offerUrl())
                .build();
       Offer savedoffer = offerRepository.save(offer);
        return new OfferResponseDto(
                savedoffer.id(),
                savedoffer.companyName(),
                savedoffer.position(),
                savedoffer.salary(),
                savedoffer.offerUrl());
    }
}
