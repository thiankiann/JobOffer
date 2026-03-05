package com.junioroffers.http.errors;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Fault;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.junioroffers.domain.offer.OfferFetchable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.web.server.ResponseStatusException;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class OfferFetcherRestTemplateErrorsIntegrationTest {


    @RegisterExtension
    public static WireMockExtension wireMockServer = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();
    OfferFetchable offerFetchable = new OfferFetcherRestTemplateIntegrationTestConfig()
            .remoteOfferClient(wireMockServer.getPort(),1000, 1000);

    @Test
    void should_return_null_numbers_when_fault_connection_reset_by_peer() {
        // given
        wireMockServer.stubFor(WireMock.get("/offers")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withHeader("Content-Type", "application/json")
                        .withFault(Fault.CONNECTION_RESET_BY_PEER)));

        // when
        Throwable throwable = catchThrowable(() -> offerFetchable.fetchOffers());

        // then
        assertThat(throwable).isInstanceOf(ResponseStatusException.class);
        assertThat(throwable.getMessage()).isEqualTo("500 INTERNAL_SERVER_ERROR");
    }
    @Test
    void should_return_null_numbers_when_fault_empty_response() {
        // given
    }
}
