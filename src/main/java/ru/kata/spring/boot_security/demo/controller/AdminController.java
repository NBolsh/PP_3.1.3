package ru.kata.spring.boot_security.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;



    @Autowired
    public AdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping( "/users")
    public String showAllUsers(Model model){

        model.addAttribute("allUsers", userService.getAllUsers());
        return "users/list";
    }

    @GetMapping("users/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "users/userInfo";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user,
                          BindingResult bindingResult){

        if (bindingResult.hasErrors()) { return "users/userInfo"; }
        userService.addUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("users/edit")
    public String findUser(@RequestParam("userId") Long id,
                           Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "users/userInfo";
    }

    @GetMapping("users/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

}
