package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
class OfferMapper {

    public final OfferService offerService;

//    OfferResponseDto mapOfferToOfferResponseDto(Optional<Offer> jobOfferResponseDto) {
//        return  offerService.findOfferById()
//                .map( offer -> new OfferResponseDto(
//                        offer.id()
//                        ),
                                //.toString());
//  return repository.findUserByName(username)
//                .map(user -> new UserDto(user.id(),user.password(),user.username()))
//                        .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND) );
//    }
}
