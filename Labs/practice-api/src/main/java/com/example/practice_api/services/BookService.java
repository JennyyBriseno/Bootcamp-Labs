package com.example.practice_api.services;

import com.example.practice_api.exceptions.ResourceNotFoundException;
import com.example.practice_api.models.Book;
import com.example.practice_api.models.dto.BookDTO;
import com.example.practice_api.models.dto.CreateBookDTO;
import com.example.practice_api.models.dto.UpdateBookDTO;
import com.example.practice_api.models.mapper.BookMapper;
import com.example.practice_api.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getAllBooks(){
        List<Book> books = bookRepository.findAll();

        return books.stream().map(BookMapper::toDTO).toList();
    }

    public BookDTO getBookById(Long id){
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Book was not found with id: " + id));
        //If it's there, convert to DTO for display to client
        return BookMapper.toDTO(book);
    }

    public void deleteBook(Long id){
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Book was not found with id: " + id));
        //If it is there, delete it
        bookRepository.delete(book);
    }

    public BookDTO createBook(CreateBookDTO dto){
        Book book = BookMapper.toEntity(dto);
        Book bookCreated = bookRepository.save(book);

        return BookMapper.toDTO(bookCreated);
    }

    public BookDTO updateBook(UpdateBookDTO dto, Long id){
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Book was not found with this id: " + id));

        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        return BookMapper.toDTO(book);
    }
}
