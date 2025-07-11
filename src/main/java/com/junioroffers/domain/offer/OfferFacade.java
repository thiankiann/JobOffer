package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OfferFacade {

    private final OfferService offerService;

    public List<OfferResponseDto> findAllOffers(){
        return offerService.findAllOffers();
    }
    public List<OfferResponseDto> fetchAllOffersAndSaveIfExist(){
        return offerService.fetchAllOffersAndSaveIfExist().stream()
                .map(OfferMapper::mapOfferToOfferResponseDto)
                .collect(Collectors.toList());}

    public OfferResponseDto findOfferById(String id){
        return offerService.findOfferById(id);
    }

    public OfferResponseDto saveOffer(OfferRequestDto offerRequestDto){

        return offerService.saveOffer(offerRequestDto);
    }
    public void saveIfOfferUrlIsNotDuplicated(OfferRequestDto offerRequestDto ){

         offerService.saveIfOfferUrlIsNotDuplicated(offerRequestDto );
       //  return offerRequestDto;
    }
}
