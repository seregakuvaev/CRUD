package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.Service.CarService;

@Controller
@RequestMapping("/")
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

    @GetMapping("/cars/{id}")// ебеатьочсмол тут была ошибка
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("cars", carService.show(id));
        return "show";
    }

}
