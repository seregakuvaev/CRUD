package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.Service.ServiceDAO;

@Controller
@RequestMapping()
public class UserController {
    private final ServiceDAO serviceDAO;

    public UserController(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @GetMapping("/")
    public String welcome(){
        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model m){
        m.addAttribute("user", new User());
        m.addAttribute("listUsers", serviceDAO.list());
        return "show";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping(value="/adduser")
    public String addUser(@ModelAttribute("user") User users, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "add-user";
        }
        serviceDAO.add(users);
        return "redirect:/users";
    }

    @RequestMapping(value="/remove/{id}",method = RequestMethod.GET)
    public String removeUser(@PathVariable("id") int id){
        System.out.println(id);
        serviceDAO.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        User user = serviceDAO.getUser(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Validated User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        serviceDAO.update(user);
        return "redirect:/users";
    }

}
