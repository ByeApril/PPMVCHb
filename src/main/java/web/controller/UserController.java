package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            model.addAttribute("errorMessage", "User not found");
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            return "users";
        }
        model.addAttribute("user", user);
        return "user-form";
    }


    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            model.addAttribute("errorMessage", "User not found");
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            return "users";
        } else {
            userService.deleteUser(id);
            return "redirect:/users";
        }
    }

}