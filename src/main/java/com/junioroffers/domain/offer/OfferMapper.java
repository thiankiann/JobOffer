package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class OfferMapper {

    public final OfferService offerService;

    public static OfferResponseDto mapOfferToOfferResponseDto(Offer offerById) {
        return OfferResponseDto.builder()
                .id(offerById.id())
                .companyName(offerById.companyName())
                .position(offerById.position())
                .salary(offerById.salary())
                .offerUrl(offerById.offerUrl())
                .build();

    }
}
