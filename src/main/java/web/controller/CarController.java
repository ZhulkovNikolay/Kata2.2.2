package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImpl carServiceImp;

    @GetMapping(value = "/cars")
    public String carList(@RequestParam(value = "count", required = false) Integer count, Model model) {
        model.addAttribute("carCount", "Car count = " + count);

        if (count <= 5) {
            model.addAttribute("carList", carServiceImp.getLimitCarList(count));
        } else {
            model.addAttribute("carList", carServiceImp.getCars());
        }

        return "cars";
    }

}
/*
5. Создайте страницу cars.html. Реализуйте создание таблицы с машинами из сервиса с помощью thymeleaf.
6. При запросе /cars выводить весь список. При запросе /cars?count=2 должен отобразиться список из 2 машин,
при /cars?count=3 - из 3, и тд. При count ≥ 5 выводить весь список машин.*/
