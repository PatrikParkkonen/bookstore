package fi.haagahelia.project.Bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fi.haagahelia.project.Bookstore.domain.BookRepository;

;




@Controller
public class BookstoreController {
	
	@Autowired
	private BookRepository repository; 
	
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
        
    	@RequestMapping(value="/seppo", method = RequestMethod.GET)
    	public String sayHello() {
    		return "bookstoreindex";
	}
}



