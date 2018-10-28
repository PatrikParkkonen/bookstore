package fi.haagahelia.project.Bookstore;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import fi.haagahelia.project.Bookstore.domain.Category;
import fi.haagahelia.project.Bookstore.domain.Book;
import fi.haagahelia.project.Bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = brepository.findByTitle("The Year of the Hare");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("The Year of the Hare");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, "9780345391803", "12,90€", new Category("Sci-Fi"));
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    

}