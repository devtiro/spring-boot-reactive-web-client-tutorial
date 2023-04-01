package com.devtiro.reactivetutorial.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devtiro.reactivetutorial.domain.Book;
import com.devtiro.reactivetutorial.domain.PagedResponse;
import com.devtiro.reactivetutorial.services.BookService;
import com.devtiro.reactivetutorial.services.BooksClient;

import reactor.core.publisher.Flux;

@Service
public class BookServiceImpl implements BookService {

    private final BooksClient booksClient;

    public BookServiceImpl(final BooksClient booksClient) {
        this.booksClient=booksClient;
    }

    @Override
    public Flux<Book> getBooks(Integer page) {
        return booksClient.getBooks(page)
        .map(PagedResponse::getContent)
        .flatMapMany(Flux::fromIterable);
    }

}
