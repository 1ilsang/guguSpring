package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j
// Security 626 page ~
public class CommonController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/accessError")
    public void accessDenied(Authentication auth, Model model) {
        log.info("access Denied : " + auth);
        model.addAttribute("msg", "Access Denied");
    }

    @GetMapping("/customLogin")
    public void loginInput(String error, String logout, Model model) {
        log.info("error: " + error);
        log.info("logout: " + logout);

        if (error != null) {
            model.addAttribute("error", "Login Error Check Your Account");
        }
        if (logout != null) {
            model.addAttribute("logout", "Logout!!");
        }
    } // end loginInput()

    @GetMapping("/customLogout")
    public void logoutGET() {
        log.info("custom logout");
    }

    @PostMapping("/customLogout")
    public void logoutPost() {
        log.info("Post custom logout");
    }
}
