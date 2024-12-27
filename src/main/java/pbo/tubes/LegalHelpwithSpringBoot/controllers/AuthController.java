package pbo.tubes.LegalHelpwithSpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import pbo.tubes.LegalHelpwithSpringBoot.dto.RegistrationDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;
import pbo.tubes.LegalHelpwithSpringBoot.services.PenggunaService;

@Controller
public class AuthController {
    private PenggunaService penggunaService;

    public AuthController(PenggunaService penggunaService) {
        this.penggunaService = penggunaService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDTO user = new RegistrationDTO();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user")RegistrationDTO user,
                           BindingResult result, Model model) {
        Pengguna existingUserEmail = penggunaService.findByEmail(user.getEmail());
        if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/register?fail";
        }
        Pengguna existingUserUsername = penggunaService.findByUsername(user.getUsername());
        if(existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty()) {
            return "redirect:/register?fail";
        }
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        penggunaService.saveUser(user);
        return "redirect:/clubs?success";
    }
}
