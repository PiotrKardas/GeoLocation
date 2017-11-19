package com.example.mapy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.mapy.Location;

@Controller
public class MapController {

    @GetMapping("/")
    public String addAdres() {
        return "map/add";
    }


    @GetMapping("/result")
    public String result(@RequestParam String address, ModelMap modelMap) {
        modelMap.put("location", Location.getLocationFromAddress(address));
        modelMap.put("url", Location.getGoogleUrlFromAddress(address));
        return "map/result";
    }
}


