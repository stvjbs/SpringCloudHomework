package ru.gb.issue_service.provider;

import ru.gb.issue_service.dto.Book;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BookProvider {

    private final WebClient webClient;

    public BookProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public Book getRandomBook() {
        return webClient.get()
                .uri("http://book-service/book/random")
                .retrieve()
                .bodyToMono(Book.class)
                .block();
    }
}
