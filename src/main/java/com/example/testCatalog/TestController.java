package com.example.testCatalog;


import com.example.testCatalog.services.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestController {


    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    public TestService testService;


    @GetMapping("/")
    public String list() {
        return "index";
    }

    /**
     * Добавляет в модель список книг из БД с уникальными авторами
     * @param searchAuthor ФИО автора.
     * При использовании данного параметра в запросе в модель добавляется список книг данного автора.
     * (показывается в сплывающем диалоге)
     * @return authors.ftl
     */
    @RequestMapping(value = "/listAuthors", method = RequestMethod.GET)
    public String listAuthors(Model model, @RequestParam(value = "p" ,defaultValue = "",required = false) String searchAuthor) {
        model.addAttribute("authors",testService.listByAuthor(""));
        if (!searchAuthor.isEmpty())
            model.addAttribute("booksFilteredByAuthor",testService.listByAuthor(searchAuthor));
        return "authors";
    }

    /**
     * Добавляет в модель список книг из БД
     * @param searchTitle Название книги.
     * В модель добавляется список книг с данным названием.
     * (Авторы книг показываются в сплывающем диалоге)
     * @return titles.ftl
     */
    @RequestMapping(value = "/listBooks", method = RequestMethod.GET)
    public String listBooks(Model model, @RequestParam(value = "p" ,defaultValue = "", required = false) String searchTitle) {
        model.addAttribute("books",testService.listByTitle(""));
        if (!searchTitle.isEmpty())
            model.addAttribute("booksFilteredByTitle",testService.listByTitle(searchTitle));
        return "titles";
    }


}
