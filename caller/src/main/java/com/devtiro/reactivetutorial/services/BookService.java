package com.devtiro.reactivetutorial.services;

import com.devtiro.reactivetutorial.domain.Book;

import reactor.core.publisher.Flux;

/**
 * Service to deal with Books
 */
public interface BookService {

    Flux<Book> getBooks(final Integer page);

}
