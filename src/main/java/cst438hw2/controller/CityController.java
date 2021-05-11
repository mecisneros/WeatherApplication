package cst438hw2.controller;

import cst438hw2.domain.CityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cst438hw2.service.CityService;


@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities/{city}")
    public String getCityInfo(@PathVariable("city") String cityName,
                              Model model) {
        CityInfo cityInfo = cityService.getCityInfo(cityName);

        if(cityInfo == null){
            return "ErrorPage";
        }

        model.addAttribute("cityInfo",cityInfo);
        return "CityDetails";
    }
}
