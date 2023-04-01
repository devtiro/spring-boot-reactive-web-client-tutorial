package com.devtiro.reactivetutorial.services.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.devtiro.reactivetutorial.domain.Book;
import com.devtiro.reactivetutorial.domain.PagedResponse;
import com.devtiro.reactivetutorial.services.BooksClient;

import reactor.core.publisher.Mono;

@Service
public class BooksClientImpl implements BooksClient {

    private final WebClient webClient;

    public BooksClientImpl(final WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<PagedResponse<Book>> getBooks(Integer page) {
        final ParameterizedTypeReference<PagedResponse<Book>> pagedResponseBooks =
            new ParameterizedTypeReference<PagedResponse<Book>>() {
        };

        return webClient.get()
                .uri(builder -> builder.path("/books").queryParam("page", page).build())
                .retrieve()
                .bodyToMono(pagedResponseBooks);
    }

}
