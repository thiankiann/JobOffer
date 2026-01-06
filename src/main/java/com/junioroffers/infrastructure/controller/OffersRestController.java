package com.junioroffers.infrastructure.controller;

import com.junioroffers.domain.offer.OfferFacade;
import com.junioroffers.domain.offer.dto.JobOfferResponse;
import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/offers")
class OffersRestController {

    private final OfferFacade offerFacade;

    @GetMapping
    public ResponseEntity<List<OfferResponseDto>> findAllOffers(){
        List<OfferResponseDto> allOffers = offerFacade.findAllOffers();
        return ResponseEntity.ok(allOffers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferResponseDto> findOfferById(@PathVariable String id){
        OfferResponseDto offerById = offerFacade.findOfferById(id);
        return ResponseEntity.ok(offerById);
    }
    @PostMapping
    public ResponseEntity<OfferResponseDto> addOffer(@RequestBody @Valid OfferRequestDto offerDto) {
        OfferResponseDto offerResponseDto = offerFacade.saveOffer(offerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(offerResponseDto);
    }
    //    @PostMapping  //wrong
//    public ResponseEntity<OfferResponseDto> inputNumbers(@RequestBody @Valid OfferRequestDto requestDto) {
//        OfferResponseDto offerResponseDto = offerFacade.saveOffer(requestDto);
//        return ResponseEntity.ok(offerResponseDto); // here is mistake - 200 (ok) instead 201 (created)
//    }
}
