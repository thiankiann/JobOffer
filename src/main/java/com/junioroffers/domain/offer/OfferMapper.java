package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponse;
import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;
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
        final Offer offer = Offer.builder()
                .companyName(offerDto.companyName())
                .position(offerDto.position())
                .salary(offerDto.salary())
                .offerUrl(offerDto.offerUrl())
                .build();
        return offer;
    }

    static OfferResponseDto mapJobOfferResponseToOfferResponseDto(JobOfferResponse jobOfferResponse) {
        return OfferResponseDto.builder()
                .companyName(jobOfferResponse.company())
                .position(jobOfferResponse.title())
                .salary(jobOfferResponse.salary())
                .offerUrl(jobOfferResponse.offerUrl())
                .build();
    }

    public static Offer mapJobOfferResponseToOffer(JobOfferResponse jobOfferResponse) {
        return Offer.builder()
                .companyName(jobOfferResponse.company())
                .position(jobOfferResponse.title())
                .salary(jobOfferResponse.salary())
                .offerUrl(jobOfferResponse.offerUrl())
                .build();
    }
}
