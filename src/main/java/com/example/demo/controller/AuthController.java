package com.example.demo.controller;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userDto", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userDto") UserRegistrationDto userDto,
                           BindingResult result,
                           Model model,
                           RedirectAttributes redirectAttributes) {

        // 1. 檢查基礎欄位驗證是否通過 (例如 Email 格式、長度等)
        if (result.hasErrors()) {
            return "register"; // 返回頁面顯示錯誤訊息
        }

        try {
            userService.register(userDto);
            redirectAttributes.addFlashAttribute("success", "註冊成功，請登入");
            return "redirect:/login";
        } catch (RuntimeException e) {
            // 2. 處理業務邏輯錯誤 (例如 帳號重複)
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "dashboard";
    }
}