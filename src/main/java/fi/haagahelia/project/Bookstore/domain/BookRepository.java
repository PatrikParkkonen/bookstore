package fi.haagahelia.project.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.project.Bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);
    
}