package ru.vinogradov.homework_04.myPersist;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Product {

    private Long id;
    @Size(max = 20)
    @NotBlank
    private String productName;

    @Pattern(regexp = "(01)(\\d{14})", message = "Invalid barcode format")
    @NotBlank
    private String barcode;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format")
    @NotBlank
    private String MFG_date;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format")
    @NotBlank
    private String EXP_date;

    public Product(String productName) {
        this.productName = productName;
    }
}
