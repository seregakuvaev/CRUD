package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.Model.User;
import web.Service.ServiceDAOImp;

@Controller
@RequestMapping()
public class UserController {
    ServiceDAOImp serviceDAOImp = new ServiceDAOImp();

    @GetMapping("/")
    public String welcome(){
        return "index";
    }

    public ServiceDAOImp getServiceDAOImp() {
        return serviceDAOImp;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model m){
        m.addAttribute("user", new User());
        m.addAttribute("listUsers", serviceDAOImp.list());
        return "show";
    }

//    @RequestMapping(value="/users/add",method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("user") User user){
//        if(user.getId() == 0){
//            userServiceImp.add(user);
//        }else {
//            userServiceImp.update(user);
//        }
//        return "redirect:/users";
//    }
//
//    @RequestMapping(value="/remove/{id}",method = RequestMethod.GET)
//    public String removeUser(@PathVariable("id") int id){
//        userServiceImp.delete(id);
//        return "redirect:/users";
//    }
//
//    @RequestMapping("edit/{id}")
//    public String editUser(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", userServiceImp.getUser(id));
//        model.addAttribute("listUsers", userServiceImp.list());
//        return "users";
//    }
//
//    @RequestMapping(value="userdata/{id}")
//    public String userData(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", userServiceImp.getUser(id));
//        return "userdata";
//    }
}
