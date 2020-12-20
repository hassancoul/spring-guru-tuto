package com.devhas.springgurututo.repositories;

import com.devhas.springgurututo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
