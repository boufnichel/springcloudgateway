package com.pragmaticprogrammers.scgexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ScgExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(ScgExampleApplication.class, args);
  }

  @Bean
  public KeyResolver ipKeyResolver() {
    return exchange ->
        Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
  }
}
