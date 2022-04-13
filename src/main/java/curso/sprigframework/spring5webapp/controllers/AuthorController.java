package curso.sprigframework.spring5webapp.controllers;

import curso.sprigframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
        public String getauthors(Model model){
            model.addAttribute("authors", authorRepository.findAll());

            return "authors/list.html";
        }
}
