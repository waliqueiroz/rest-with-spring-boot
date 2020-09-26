package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import br.com.erudio.data.vo.BookVO;
import br.com.erudio.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public List<BookVO> findAll() {
        List<BookVO> books = bookService.findAll();
        books.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return books;
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public BookVO findById(@PathVariable Long id) {
        BookVO bookVO = bookService.findById(id);
        bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return bookVO;
    }

    @PostMapping(consumes = { "application/json", "application/xml", "application/x-yaml" }, produces = {
            "application/json", "application/xml", "application/x-yaml" })
    public BookVO create(@RequestBody BookVO book) {
        BookVO bookVO = bookService.create(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
        return bookVO;
    }

    @PutMapping(consumes = { "application/json", "application/xml", "application/x-yaml" }, produces = {
            "application/json", "application/xml", "application/x-yaml" })
    public BookVO update(@RequestBody BookVO book) {
        BookVO bookVO = bookService.update(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
        return bookVO;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

}
