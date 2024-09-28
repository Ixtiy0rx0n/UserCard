package org.example.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CardDto {
    private Integer id;
    @NotBlank(message = "card name is required")
    private String name;
    @NotBlank(message = "Card number is required.")
    private String number;
    private Double price;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
