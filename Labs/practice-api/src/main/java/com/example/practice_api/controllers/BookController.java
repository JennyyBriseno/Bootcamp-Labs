package com.example.practice_api.controllers;

import com.example.practice_api.models.dto.BookDTO;
import com.example.practice_api.models.dto.CreateBookDTO;
import com.example.practice_api.models.dto.UpdateBookDTO;
import com.example.practice_api.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks(){
        var books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody CreateBookDTO dto){
        var book = bookService.createBook(dto);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@Valid @RequestBody UpdateBookDTO dto, @PathVariable Long id){
        var book = bookService.updateBook(dto, id);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
