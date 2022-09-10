package ru.vinogradov.homework_07.myRest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vinogradov.exceptions.EntityNotFoundException;
import ru.vinogradov.model.dto.ProductDto;
import ru.vinogradov.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService service;

    @GetMapping
    public List<ProductDto> listPage(
            @RequestParam(required = false) String productNameFilter,
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size,
            @RequestParam(required = false) Optional<String> sortField,
            Model model
    ) {
        Integer pageValue = page.orElse(1) - 1;
        Integer sizeValue = size.orElse(3);
        String sortFieldValue = sortField.filter(s -> s.isBlank()).orElse("id");
        Page<ProductDto> allByFilter = service.findAllByFilter(productNameFilter, pageValue, sizeValue, sortFieldValue);
        List<ProductDto> products = allByFilter.get().collect(Collectors.toList());
        return products;
    }

    @GetMapping("/{id}")
    public ProductDto form(@PathVariable("id") long id, Model model) {
        ProductDto productDto = service.findProductById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        return productDto;
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductDto user) {
        if (product.getId() != null) {
            throw new IllegalArgumentException("Created product shouldn't have id");
        }
        service.save(product);
        return product;
    }
}
