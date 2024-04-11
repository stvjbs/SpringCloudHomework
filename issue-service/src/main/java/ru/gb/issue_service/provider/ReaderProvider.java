package ru.gb.issue_service.provider;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.gb.issue_service.dto.Reader;

@Component
public class ReaderProvider {

    private final WebClient webClient;

    public ReaderProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public Reader getRandomReader() {

        return webClient.get()
                .uri("http://reader-service/reader/random")
                .retrieve()
                .bodyToMono(Reader.class)
                .block();
    }
}
