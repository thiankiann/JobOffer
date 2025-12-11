package com.junioroffers.infrastructure.controller;

import com.junioroffers.domain.offer.OfferFacade;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
class OfferByIdRestController {
    private final OfferFacade offerFacade;

    @GetMapping("/offer/{id}")
    public ResponseEntity<OfferResponseDto> checkOfferById(@PathVariable String offerId){
        OfferResponseDto offerById = offerFacade.findOfferById(offerId);
        return ResponseEntity.ok(offerById);
    }
}
