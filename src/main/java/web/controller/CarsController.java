package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
public class CarsController {

    @Autowired
    private CarServiceImpl carServiceImp;

    @GetMapping(value = "/cars")
    public String showCarListOnPage(@RequestParam(value = "count", required = false)
                                    Integer count, Model model) {
        model.addAttribute("carCount", "Car count = " + count);

        if (count <= 5) {
            model.addAttribute("carList", carServiceImp.getLimitCarList(count));
        } else {
            model.addAttribute("carList", carServiceImp.getCars());
        }

        return "cars";
    }

}

