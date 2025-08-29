package com.junioroffers;

import com.junioroffers.infrastructure.http.OfferFetcherRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JobOffersApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobOffersApplication.class, args);
    }

//    /**
//     * Ten Bean uruchomi się przy starcie aplikacji.
//     * Zamiast używać fasady, ręcznie stworzymy i przetestujemy sam offer fetcher.
//     * To rozwiązanie nie wymaga dodawania adnotacji @Service do innych klas.
//     */
//    @Bean
//    public CommandLineRunner directOffersTestRunner(
//            RestTemplate restTemplate,
//            @Value("${offers.http.client.config.uri}") String uri,
//            @Value("${offers.http.client.config.port}") int port) {
//
//
//        return args -> {
//            System.out.println("=================================================");
//            System.out.println("== URUCHAMIAM BEZPOŚREDNI TEST FETCHERA ==");
//            System.out.println("=================================================");
//
//
//            // 1. Ręcznie tworzymy obiekt generatora, używając komponentów,
//            //    które Spring już potrafi dostarczyć (RestTemplate, uri, port).
//            OfferFetcherRestTemplate offers = new OfferFetcherRestTemplate(restTemplate, uri, port);
//
//
//            // 2. Bezpośrednio wywołujemy metodę, którą chcemy przetestować.
//            //    Teraz System.out.println() wewnątrz tej metody na pewno się wykona.
//            offers.fetchAllOffers();
//
//
//            System.out.println("=================================================");
//            System.out.println("== BEZPOŚREDNI TEST ZAKOŃCZONY ==");
//            System.out.println("=================================================");
//        };
//    }
}