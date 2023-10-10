package ru.kata.spring.boot_security.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private RoleService roleService;

    private String userInfo = "users/userInfo";



    @Autowired
    public AdminController(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping( "/users")
    public String showAllUsers(Model model){

        model.addAttribute("allUsers", userService.getAllUsers());
        return "users/list";
    }

    @GetMapping("users/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("rolesDB", roleService.showRoles());
        return userInfo;
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            model.addAttribute("user", user);
            model.addAttribute("rolesDB", roleService.showRoles());
            return userInfo;
        }
        userService.addUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("users/edit")
    public String findUser(@RequestParam("userId") Long id,
                           Model model){
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("rolesDB", roleService.showRoles());
        return userInfo;
    }

    @GetMapping("users/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

}
