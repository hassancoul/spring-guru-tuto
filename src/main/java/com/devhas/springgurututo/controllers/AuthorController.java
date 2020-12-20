package com.devhas.springgurututo.controllers;

import com.devhas.springgurututo.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/authors")
    public String getAll(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}
