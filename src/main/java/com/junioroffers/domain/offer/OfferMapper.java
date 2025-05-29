package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;

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
    static Offer mapOfferRequestDtoToOffer(OfferRequestDto offerDto) {
      //  String idd = UUID.randomUUID().toString();
        final Offer offer = Offer.builder()
       //         .id(idd)
                .companyName(offerDto.companyName())
                .position(offerDto.position())
                .salary(offerDto.salary())
                .offerUrl(offerDto.offerUrl())
                .build();
        return offer;
    }
}
