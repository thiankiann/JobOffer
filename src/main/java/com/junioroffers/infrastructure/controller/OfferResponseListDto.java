package com.junioroffers.infrastructure.controller;

import com.junioroffers.domain.offer.dto.OfferResponseDto;

import java.util.List;

public record OfferResponseListDto(List<OfferResponseDto> offers) {
}
