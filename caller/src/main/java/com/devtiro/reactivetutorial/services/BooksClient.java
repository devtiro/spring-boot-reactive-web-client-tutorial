package com.devtiro.reactivetutorial.services;

import com.devtiro.reactivetutorial.domain.Book;
import com.devtiro.reactivetutorial.domain.PagedResponse;

import reactor.core.publisher.Mono;

/**
 * Handles HTTP calls to the Books server
 */
public interface BooksClient {

    Mono<PagedResponse<Book>> getBooks(Integer page);

}
