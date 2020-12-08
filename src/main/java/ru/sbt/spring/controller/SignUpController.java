package ru.sbt.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sbt.spring.DTO.User;
import ru.sbt.spring.DAO.UserRepository;

@Controller
public class SignUpController {
    private final UserRepository repository;

    SignUpController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sign_up")
    String showSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/sign_up")
    String showSignInPage(ModelMap model, @RequestParam String userName, @RequestParam String userPass) {
        User user = new User(userName, userPass);

        if (userName.equalsIgnoreCase("admin")) {
            model.put("message", "You can't create admin profile");
            return "sign_up";
        }

        if (repository.findByLogin(userName).isPresent()) {
            model.put("message", "This login is unavailable");
            return "sign_up";
        }

        repository.save(user);
        model.put("message", "Success");
        return "sign_in";
    }
}
