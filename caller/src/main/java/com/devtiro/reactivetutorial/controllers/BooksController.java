package com.devtiro.reactivetutorial.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devtiro.reactivetutorial.domain.Book;
import com.devtiro.reactivetutorial.services.BookService;

import reactor.core.publisher.Flux;

@RestController
public class BooksController {

    private final BookService bookService;

    public BooksController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/books")
    public Flux<Book> listBooks(@RequestParam(name = "page", required = false) final Integer page) {
        final Integer requestPage = Optional.ofNullable(page).orElse(0);
        return bookService.getBooks(requestPage);
    }

}
