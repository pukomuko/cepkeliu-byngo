package cepkeliu.robocop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cepkeliu.robocop.model.Player;
import cepkeliu.robocop.service.PlayerService;

@Controller
public class PlayerSignupController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/")
    public String index(final ModelMap map) {

        map.put("player", playerService.getById(10L, Player.class));

        return "player";
    }
}
