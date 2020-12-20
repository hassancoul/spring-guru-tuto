package com.devhas.springgurututo.repositories;

import com.devhas.springgurututo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
