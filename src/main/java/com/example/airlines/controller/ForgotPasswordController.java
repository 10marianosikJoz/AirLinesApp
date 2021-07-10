package com.example.airlines.controller;

import com.example.airlines.dto.UserDTO;
import com.example.airlines.email.EmailSender;
import com.example.airlines.email.UtilityPath;
import com.example.airlines.model.User;
import com.example.airlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSender emailSender;

    @GetMapping("/forgotPassword")
    public String forgotPasswordForm(@ModelAttribute("user") UserDTO userDTO, Model model) {
        model.addAttribute(userDTO);
        return "forgotPassword";
    }

    @GetMapping("/reset_password")
    public String resetPasswordForm(@Param(value = "token") String token, @ModelAttribute("user") UserDTO userDTO, Model model) {
        User userByToken = userService.getUserByToken(token);
        if (userByToken == null) {
            model.addAttribute("message", "Invalid token");
            return "message";
        }

        model.addAttribute(userDTO);
        model.addAttribute("token", token);

        return "resetPassword";


    }

    @PostMapping("/reset_password")
    public String processResetPasswordForm(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO, Model model) {
       String token = request.getParameter("token");
       String password = request.getParameter("password");

        User userByToken = userService.getUserByToken(token);
        if (userByToken == null) {
            model.addAttribute("message", "Invalid token");
            return "message";
        }
        else {
            userService.updatePassword(userByToken,password);
            model.addAttribute("message", "Successfully changed password");
        }
        return "resetPassword";
    }

    @PostMapping("/forgotPassword")
    public String processForgotPasswordForm(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO,
                                            Model model) throws UnsupportedEncodingException, MessagingException {

        model.addAttribute(userDTO);
        String email = request.getParameter("email");
        String token = UUID.randomUUID().toString();

        boolean present = userService.existByEmail(userDTO.getEmail());
        if (!present) {
            return "redirect:/forgotPassword?emailFailed";
        } else {
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = UtilityPath.getSiteURL(request) + "/reset_password?token=" + token;
            emailSender.sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "We have send an email to your account. Check your email !");
            return "forgotPassword";
        }

    }
}
