package fi.haagahelia.project.Bookstore.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@ResponseBody
public class BookstoreController {
	
	@RequestMapping("/")
	public String indexHi() {
		return "Welcome to the bookstore!";
	}
}



