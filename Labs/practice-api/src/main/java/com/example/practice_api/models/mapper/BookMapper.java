package com.example.practice_api.models.mapper;

import com.example.practice_api.models.Book;
import com.example.practice_api.models.dto.BookDTO;
import com.example.practice_api.models.dto.CreateBookDTO;
import com.example.practice_api.models.dto.UpdateBookDTO;

public class BookMapper {
    public static BookDTO toDTO(Book book){
        BookDTO dto = new BookDTO();

        dto.setId(book.getId());
        dto.setIsbn(book.getIsbn());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());

        return dto;
    }

    public static Book toEntity(BookDTO dto){
        Book book = new Book();

        book.setId(dto.getId());
        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        return book;
    }

    public static Book toEntity(CreateBookDTO dto){
        Book book = new Book();

        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        return book;
    }

    public static Book toEntity(UpdateBookDTO dto){
        Book book = new Book();

        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        return book;
    }
}
