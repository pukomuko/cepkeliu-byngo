package cepkeliu.robocop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cepkeliu.robocop.service.GameService;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/game/phrases", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public List<String> phrases() {
        return gameService.getPhraseTexts();
    }
}
