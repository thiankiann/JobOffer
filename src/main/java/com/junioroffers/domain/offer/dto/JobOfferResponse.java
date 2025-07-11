package com.junioroffers.domain.offer.dto;

import lombok.Builder;

@Builder
public record JobOfferResponse(
        String company,
        String title,
        String salary,
        String offerUrl
) {
}
