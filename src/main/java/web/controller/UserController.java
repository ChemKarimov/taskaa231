package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @RequestMapping(value ="/addUser", method = RequestMethod.GET)
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users/";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users/";
    }

    @RequestMapping(value ="/updateInfo", method = RequestMethod.GET)
    public String updateUser(@RequestParam("userId") int id, Model model) {
        model.addAttribute("action", "update");
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping(value ="/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("userId") int id) {
        User user = userService.getUserById(id);
        userService.delete(user);
        return "redirect:/users/";
    }
}