package ru.sbt.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sbt.spring.DAO.AuditRepository;
import ru.sbt.spring.DAO.UserRepository;
import ru.sbt.spring.LoginStatus;
import ru.sbt.spring.DAO.entity.Audit;

@Controller
public class SignInController {
    private final UserRepository userRepository;
    private final AuditRepository auditRepository;

    SignInController(UserRepository userRepository, AuditRepository auditRepository) {
        this.userRepository = userRepository;
        this.auditRepository = auditRepository;
    }

    @GetMapping("/")
    String showSignInPage() {
        return "sign_in";
    }

    @PostMapping("/")
    String showWelcomePage(ModelMap model, @RequestParam String userName, @RequestParam String userPass) {
        if (userRepository.findByLoginAndPassword(userName, userPass).isPresent()) {
            auditRepository.save(new Audit(userName, LoginStatus.SUCCESS));
            model.put("username", userName);
            return "welcome";
        }

        if (userRepository.findByLogin(userName).isPresent()) {
            auditRepository.save(new Audit(userName, LoginStatus.WRONG_PASSWORD));
        } else {
            auditRepository.save(new Audit(userName, LoginStatus.WRONG_LOGIN));
        }

        model.put("message", "User doesn't exist or password is incorrect");
        return "sign_in";
    }
}
