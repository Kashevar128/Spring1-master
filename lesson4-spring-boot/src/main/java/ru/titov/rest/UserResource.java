package ru.titov.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.titov.exceptions.EntityNotFoundException;
import ru.titov.model.User;
import ru.titov.model.dto.UserDto;
import ru.titov.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

    @GetMapping
    public Page<UserDto> listPage(
            @RequestParam(required = false) String usernameFilter,
            @RequestParam(required = false) String emailFilter,
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size,
            @RequestParam(required = false) Optional<String> sortField,
            Model model
    ) {
        Integer pageValue = page.orElse(1) - 1;
        Integer sizeValue = size.orElse(3);
        String sortFieldValue = sortField.filter(s -> s.isBlank()).orElse("id");
        Page<UserDto> allByFilter = service.findAllByFilter(usernameFilter, emailFilter, pageValue, sizeValue, sortFieldValue);
        return allByFilter;
    }

    @GetMapping("/{id}/id")
    public UserDto form(@PathVariable("id") long id, Model model) {
        return service.findUserById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("Created user shouldn't have id");
        }
        service.save(user);
        return user;
    }


}
