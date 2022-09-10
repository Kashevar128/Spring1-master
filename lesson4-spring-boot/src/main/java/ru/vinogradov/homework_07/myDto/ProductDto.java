package ru.vinogradov.homework_07.myDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private Long id;

    @NotBlank(message = "can not be empty!!!")
    private String productName;

    @NotBlank
    private String price;



}
