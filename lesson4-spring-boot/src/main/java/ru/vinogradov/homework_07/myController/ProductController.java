package ru.vinogradov.homework_07.myController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vinogradov.homework_07.myPersist.Product;
import ru.vinogradov.homework_07.myPersist.ProductRepository;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public String listPage(@RequestParam Optional<String> productNameFilter, Model model) {
        if(productNameFilter.isEmpty() || productNameFilter.get().isBlank()) {
            model.addAttribute("products", productRepository.findAll());
        } else {
            model.addAttribute("products", productRepository.findAllByProductNameLike("%" + productNameFilter.get() + "%"));
        }
        return "product";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "product_form";
    }

    @GetMapping("/newPr")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product(""));
        return "product_form";
    }

    @GetMapping("/deletePr/{id}")
    public String deleteProductById(@PathVariable long id) {
        productRepository.deleteById(id);
        return "redirect:/product";
    }

    @PostMapping
    public String saveProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product_form";
        }
        productRepository.save(product);
        return "redirect:/product";
    }

    @PostMapping("/updatePr")
    public String updateProduct(Product product) {
        productRepository.save(product);
        return "redirect:/product";
    }


}
