package com.devhas.springgurututo.bootstrap;

import com.devhas.springgurututo.model.Author;
import com.devhas.springgurututo.model.Book;
import com.devhas.springgurututo.repositories.AuthorRepository;
import com.devhas.springgurututo.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {
        Author hassane = new Author("Hassane", "Coulibaly");
        Book book1 = new Book("Ville Intélligente et Participation Citoyenne", "1234N", "Atlas Edition");
        hassane.getBooks().add(book1);
        book1.getAuthors().add(hassane);

        authorRepository.save(hassane);
        bookRepository.save(book1);

        Author eric = new Author("Eric", "Koffi");
        Book book2 = new Book("L'art du coupé décalé en fin d'année", "4321F", "Nouvelle edition ivoirienne");
        eric.getBooks().add(book2);
        book2.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book2);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
