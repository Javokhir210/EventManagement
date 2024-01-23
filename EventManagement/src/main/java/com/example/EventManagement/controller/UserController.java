package com.example.EventManagement.controller;

import com.example.EventManagement.dto.AdminDto;
import com.example.EventManagement.dto.UserDto;
import com.example.EventManagement.models.Admins;
import com.example.EventManagement.models.Users;
import com.example.EventManagement.services.AdminService;
import com.example.EventManagement.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService userService;
    private AdminService adminService;

    @Autowired
    public UserController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping("/reg")
    public String regUser(Model model){
        Users user = new Users();
        model.addAttribute("user", user);
        return "register-page";
    }

    @PostMapping("/reg")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result){
        if (result.hasErrors()){
            return "register-page";
        }
        userService.saveUser(userDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model){
        Users users = new Users();
        model.addAttribute("user", users);
        return "login-page";
    }

    @PostMapping("/login")
    public String userLogin(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model){
        boolean valid = userService.loginUser(userDto.getName(), userDto.getPassword());
        if(valid){
//            session.setAttribute("id1", userDto.getId());
//            session.setAttribute("eventId1");
            return "redirect:/events";
        }else {
            model.addAttribute("loginError", true);
            return "login-page";
        }
    }

    @GetMapping("/login_admin")
    public String loginAdmin(Model model){
        Admins admins = new Admins();
        model.addAttribute("admin", admins);
        return "login_admin";
    }

    @PostMapping("/login_admin")
    public String adminLogin(@Valid @ModelAttribute("admin") AdminDto adminDto, BindingResult result, Model model){
        boolean valid = adminService.loginAdmin(adminDto.getName(), adminDto.getPassword());
        if(valid){
            return "redirect:/admin-events";
        }else {
            model.addAttribute("adminLoginError", true);
            return "login_admin";
        }
    }
}
