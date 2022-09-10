package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.CarService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cars", carService.index());
        return "index";
    }

    @GetMapping("/")
    public String show(@RequestParam(value = "count", required = false) int count, Model model){
        model.addAttribute("cars", carService.show(count));
        return "show";
    }

}
