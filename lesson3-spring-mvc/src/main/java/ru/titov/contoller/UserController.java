package ru.titov.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.titov.persist.User;
import ru.titov.persist.UserRepository;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository  userRepository;

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "user_form";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User(""));
        return "user_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.delete(id);
        return "redirect:/user";
    }

    @PostMapping
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/user";
    }

    //Каждая аннотация вмещает в себя метод, который работает с отдельным http - запросом


}
