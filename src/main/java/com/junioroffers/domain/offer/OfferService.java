package com.junioroffers.domain.offer;


import com.junioroffers.domain.offer.dto.JobOfferResponseDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
class OfferService {
    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;
    private final OfferNotFoundException offerNotFoundException;

//    OfferResponseDto findOfferById(String id) {
//        Optional<Offer> offerById = offerRepository.findOfferById(id);
//              //  .orElseThrow( () -> (new OfferNotFoundException("Offer Not Found")));
//        OfferResponseDto offerResponseDto = new OfferResponseDto(
//                offerById.get().id(),
//                offerById.get().companyName(),
//                offerById.get().position(),
//                offerById.get().salary(),
//                offerById.get().offerUrl()) ;
//        return offerResponseDto;
//
//        // offerMapper.mapOfferToOfferResponseDto(offerById);
//
//
//        //    OfferResponseDto mapOfferToOfferResponseDto(Optional<Offer> jobOfferResponseDto) {
////        return  offerService.findOfferById()
////                .map( offer -> new OfferResponseDto(
////                        offer.id()
////                        ),
//        //.toString());
////  return repository.findUserByName(username)
////                .map(user -> new UserDto(user.id(),user.password(),user.username()))
////                        .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND) );
//    }
}
