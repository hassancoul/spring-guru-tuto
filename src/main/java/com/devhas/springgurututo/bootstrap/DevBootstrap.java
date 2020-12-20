package com.devhas.springgurututo.bootstrap;

import com.devhas.springgurututo.model.Author;
import com.devhas.springgurututo.model.Book;
import com.devhas.springgurututo.model.Publisher;
import com.devhas.springgurututo.repositories.AuthorRepository;
import com.devhas.springgurututo.repositories.BookRepository;
import com.devhas.springgurututo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {
        Publisher publisher1 = new Publisher("Atlas Edition", "US, NY, Street 5");
        publisherRepository.save(publisher1);

        Author hassane = new Author("Hassane", "Coulibaly");
        Book book1 = new Book("Ville Intélligente et Participation Citoyenne", "1234N", publisher1);
        hassane.getBooks().add(book1);
        book1.getAuthors().add(hassane);

        publisherRepository.save(publisher1);
        authorRepository.save(hassane);
        bookRepository.save(book1);

        Publisher publisher2 = new Publisher("Nouvelle edition ivoirienne", "Abidjan, Plateau, Rue des banques");
        publisherRepository.save(publisher2);
        
        Author eric = new Author("Eric", "Koffi");
        Book book2 = new Book("L'art du coupé décalé en fin d'année", "4321F", publisher2);
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
