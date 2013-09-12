package cepkeliu.robocop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cepkeliu.robocop.service.MeetingsService;

@Controller
public class PlayerSignupController {

    @Autowired
    private MeetingsService meetingsService;

    @RequestMapping("/")
    public String index(final ModelMap map) {
        map.put("meetings", meetingsService.getAll());
        return "signup";
    }
}
