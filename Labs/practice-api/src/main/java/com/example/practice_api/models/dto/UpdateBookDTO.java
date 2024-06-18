package com.example.practice_api.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookDTO {
    @NotNull(message = "isbn cannot be empty! ")
    @Min(value = 13, message = "isbn needs a min of 13 digits")
    private Long isbn;

    @NotBlank(message = "Book needs a title!")
    @Size(max = 40, min = 5, message = "Book title is too long!")
    private String title;

    @NotBlank(message = "Book needs an author")
    @Size(max = 30,min = 5, message = "Book author length doesn't meet requirements")
    private String author;
}
