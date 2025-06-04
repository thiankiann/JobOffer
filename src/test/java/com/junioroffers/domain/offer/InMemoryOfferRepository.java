package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.OfferResponseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.junioroffers.domain.offer.OfferMapper.mapOfferToOfferResponseDto;

public class InMemoryOfferRepository implements OfferRepository {

    Map<String, Offer> database = new ConcurrentHashMap<>();

    @Override
    public Optional<Offer> findOfferById(String id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public Offer save(Offer entity) {
        UUID id = UUID.randomUUID();
        Offer offer = new Offer(
                id.toString(),
                entity.companyName(),
                entity.position(),
                entity.salary(),
                entity.offerUrl()
        );
        database.put(offer.id(),offer);
        return offer;
    }

    @Override
    public List<OfferResponseDto> findAllOffers() {

        return database.values()
                .stream()
               // .filter(ticket -> ticket.drawDate().isEqual(drawDate))
                .map(OfferMapper::mapOfferToOfferResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isUrlDuplicated(String offerUrl) {
        long count = database.values()
                .stream()
                .filter(offer -> offer.offerUrl().equals(offerUrl))
                .count();
        return count == 1;
    }

    @Override
    public List<Offer> saveAll(List<Offer> offers) {
//        Map<Long,Album> db = new HashMap<>();
//        AtomicInteger index = new AtomicInteger(0);
//
//        @Override
//        public Album save(final Album album) {
//            long index = this.index.getAndIncrement();
//            db.put(index,album);
//            album.setId(index);
//            return album;
//        }
//        List<Offer> offersList = offers.stream()
//                .map(this::save)
//                .toList();
       // database.values().addAll(offers);
       // database.put(offers.get(id))
//        for (:
//             ) {
//
//        }
        offers.stream()
                .map(offer -> database.put((offer.id()).toString(),offer));
        return offers;




//        return database.values().forEach(
//                (offer -> database.put((offer.id()).toString(),offer))
//                        .collect(Collectors.toList()));
    }
//    @Override
//    public boolean isUrlDuplicated(Offer offer) {
//        boolean  isItContain = database.containsValue(offer);
////        for (( database.get(offer.offerUrl())):
////             ) {
////
////        }
////        database.values().stream()
////                .filter(database -> database.offerUrl().equals(newUrl))
////                .map(OfferMapper::mapOfferToOfferResponseDto)
////                .contain
////
////
//
//        return isItContain;
//    }

//    @Override
//    public boolean isUrlDuplicated(Offer offer) {
//        long count = database.values()
//                .stream()
//                .filter((database.get(offer.offerUrl())).equals(offer.offerUrl());
//        return count == 1;
//    }

}
