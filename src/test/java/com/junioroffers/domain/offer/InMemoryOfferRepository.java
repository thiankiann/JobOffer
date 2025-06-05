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

        return offers.stream()
                .map(this::save)    //nie czaje jak to dziala
                .toList();

//        offers.stream()
//                .map(offer -> database.put((offer.id()), offer));  //nie wiem czemu to nie dziala
//        return offers;
    }

}
