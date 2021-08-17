package com.example.airlines.controller;

import com.example.airlines.dto.UserDTO;
import com.example.airlines.mapper.UserMapper;
import com.example.airlines.model.User;
import com.example.airlines.repository.UserRepository;
import com.example.airlines.service.CaptchaService;
import com.example.airlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CaptchaService captchaService;
    private User user = new User();

    @ModelAttribute("user")
    public UserDTO userDTO() {
        return userMapper.convertToUserDto(user);
    }

    @GetMapping
    public String registrationForm() {
        return "registration";
    }


    @PostMapping
    public String registerUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result,
                               HttpServletRequest request, HttpServletResponse httpResponse) throws IOException {
        String recaptchaResponse = request.getParameter("g-recaptcha-response");
        if (!captchaService.verifyReCaptcha(recaptchaResponse)) {
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        boolean present = userRepository.findByEmail(userDTO.getEmail()).isPresent();
        if (result.hasErrors()) {
            return "redirect:/registration?failed";
        } else if (present) {
            return "redirect:/registration?emailFailed";
        } else {
            userService.saveUser(userDTO);
            return "redirect:/registration?success";
        }

    }


}
