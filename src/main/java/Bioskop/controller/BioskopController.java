package Bioskop.controller;

import Bioskop.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BioskopController {

    @Autowired
    private BioskopService bioskopService;

    @GetMapping ("/")
    public String welcome() {
        return "home.html";
    }
}
