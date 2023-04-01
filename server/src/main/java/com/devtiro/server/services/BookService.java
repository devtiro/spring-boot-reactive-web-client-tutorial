package com.devtiro.server.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devtiro.server.domain.Book;

public interface BookService {

    Page<Book> getBooks(Pageable pageable);

    Optional<Book> getBook(String isbn);

}
