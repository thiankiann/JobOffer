package com.junioroffers.domain.offer;
import com.junioroffers.domain.offer.dto.OfferRequestDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.InstanceOfAssertFactories.iterable;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

class OfferFacadeTest {
    OfferFacade offerFacade = new OfferFacade(new OfferService(new InMemoryOfferRepository()));
    @Test
    public void should_save_4_offers_when_there_are_no_offers_in_database() {
        //given
        assertThat(offerFacade.findAllOffers())
                .isEmpty();
        OfferRequestDto offerRequestDto = new OfferRequestDto(
                "Tesla",
                "engineer",
                "£200 000",
                "www.tesla.com/offer83698"
        );
        OfferRequestDto offerRequestDto2 = new OfferRequestDto(
                "Tesla",
                "mechanic",
                "£80 000",
                "www.tesla.com/offer8369"
        );
        OfferRequestDto offerRequestDto3 = new OfferRequestDto(
                "Tesla",
                "manager",
                "£400 000",
                "www.tesla.com/offer83688"
        );
        OfferRequestDto offerRequestDto4 = new OfferRequestDto(
                "Tesla",
                "owner",
                "£400 000 000",
                "www.tesla.com/offer88898"
        );
        //when
        OfferResponseDto offerResponseDto = offerFacade.saveOffer(offerRequestDto);
        OfferResponseDto offerResponseDto2 = offerFacade.saveOffer(offerRequestDto2);
        OfferResponseDto offerResponseDto3 = offerFacade.saveOffer(offerRequestDto3);
        OfferResponseDto offerResponseDto4 = offerFacade.saveOffer(offerRequestDto4);

        //then
        assertThat(offerFacade.findAllOffers())
                .isNotEmpty()
                        .hasSize(4);
        assertThat(offerFacade.findOfferById(offerResponseDto.id())).isEqualTo((OfferResponseDto.builder()
                .id(offerResponseDto.id())
                .companyName("Tesla")
                .position("engineer")
                .salary("£200 000")
                .offerUrl("www.tesla.com/offer83698")
                .build())
        );

    }
    @Test
    public void should_save_2_offers_when_repository_had4_added_with_offer_urls() {
        //given

        //when

        //then
    }
    @Test
    public void should_throw_duplicate_key_exception_when_offer_url_exists() {
        //given
        assertThat(offerFacade.findAllOffers())
                .isEmpty();
        OfferRequestDto offerRequestDto = new OfferRequestDto(
                "Tesla",
                "engineer",
                "£200 000",
                "www.tesla.com/offer83698"
        );
        //when
        offerFacade.saveIfOfferUrlIsNotDuplicated(offerRequestDto);

        Throwable thrown = catchThrowable(() -> offerFacade.saveIfOfferUrlIsNotDuplicated(offerRequestDto));
        //then
        assertThat(thrown)
                .isInstanceOf(DuplicateKeyException.class)
                .hasMessage("Duplicate Key Exception");
    }



    @Test
    public void should_fetch_from_jobs_from_remote_and_save_all_offers_when_repository_is_empty() {
        //given

        //when

        //then
    }
    @Test
    public void should_find_offer_by_id_when_offer_was_saved() {
        //given
        OfferRequestDto offerRequestDto = new OfferRequestDto(
                "Tesla",
                "engineer",
                "£200 000",
                "www.tesla.com/offer83698"
            );
        OfferResponseDto offerResponseDto = offerFacade.saveOffer(offerRequestDto);

        //when
        OfferResponseDto offerById = offerFacade.findOfferById(offerResponseDto.id());
        //then
        assertThat(offerById).isNotNull();
        assertThat(offerById).isEqualTo(OfferResponseDto.builder()
                .id(offerResponseDto.id())
                .companyName("Tesla")
                .position("engineer")
                .salary("£200 000")
                .offerUrl("www.tesla.com/offer83698")
                .build()
        );
    }
    @Test
    public void should_save_and_find_all_offers() {
        //given
        assertThat(offerFacade.findAllOffers())
                .isEmpty();
        OfferRequestDto offerRequestDto = new OfferRequestDto(
                "Tesla",
                "engineer",
                "£200 000",
                "www.tesla.com/offer83698"
        );
        OfferRequestDto offerRequestDto2 = new OfferRequestDto(
                "Tesla",
                "mechanic",
                "£80 000",
                "www.tesla.com/offer83698"
        );
        OfferRequestDto offerRequestDto3 = new OfferRequestDto(
                "Tesla",
                "manager",
                "£400 000",
                "www.tesla.com/offer83698"
        );
        //when
        OfferResponseDto offerResponseDto = offerFacade.saveOffer(offerRequestDto);
        OfferResponseDto offerResponseDto2 = offerFacade.saveOffer(offerRequestDto2);
        OfferResponseDto offerResponseDto3 = offerFacade.saveOffer(offerRequestDto3);

        //then
        assertThat(offerFacade.findAllOffers())
                .isNotEmpty();
        assertThat(offerFacade.findOfferById(offerResponseDto.id())).isEqualTo((OfferResponseDto.builder()
                .id(offerResponseDto.id())
                .companyName("Tesla")
                .position("engineer")
                .salary("£200 000")
                .offerUrl("www.tesla.com/offer83698")
                .build())
        );
        assertThat(offerFacade.findOfferById(offerResponseDto2.id())).isEqualTo((OfferResponseDto.builder()
                .id(offerResponseDto2.id())
                .companyName("Tesla")
                .position("mechanic")
                .salary("£80 000")
                .offerUrl("www.tesla.com/offer83698")
                .build())
        );        assertThat(offerFacade.findOfferById(offerResponseDto3.id())).isEqualTo((OfferResponseDto.builder()
                .id(offerResponseDto3.id())
                .companyName("Tesla")
                .position("manager")
                .salary("£400 000")
                .offerUrl("www.tesla.com/offer83698")
                .build())
        );
    }

}
