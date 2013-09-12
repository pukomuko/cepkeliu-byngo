package cepkeliu.robocop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cepkeliu.robocop.model.Meeting;
import cepkeliu.robocop.service.GameService;
import cepkeliu.robocop.service.MeetingsService;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private MeetingsService meetingsService;

    @RequestMapping(value = "/game/phrases", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<String> phrases() {
        return gameService.getPhraseTexts();
    }
    
    @RequestMapping(value = "/game/{id}")
    public String game(@PathVariable("id") final Long id, final ModelMap map) {

        Meeting meeting = meetingsService.getById(id, Meeting.class);
        
        map.addAttribute("meeting", meeting);

        return "game";
    }

    @RequestMapping(value = "/game/{id}/info", produces = {MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<String> players(@PathVariable("id") final Long id) {
        return gameService.getPlayers(id);
    }
}
