package cepkeliu.robocop.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import cepkeliu.robocop.model.Meeting;
import cepkeliu.robocop.service.GameService;
import cepkeliu.robocop.service.MeetingInfoDto;
import cepkeliu.robocop.service.MeetingsService;

@Controller
@SessionAttributes({ "player" })
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
        map.addAttribute("phrases", gameService.randomPhrases());

        return "game";
    }

    @RequestMapping(value = "/game/{id}/info", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public MeetingInfoDto gameInfo(@PathVariable("id") final Long id, @ModelAttribute("player") final String playerName) {
        MeetingInfoDto info = gameService.getGameInfo(id);

        if (info.getWinner() != null) {
            if (info.getWinner().equalsIgnoreCase(playerName)) {
                info.setWonBeMe(true);
            }
        }
        return info;
    }
    
    @RequestMapping(value = "/game/{id}/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Boolean update(@PathVariable("id") final Long id, @RequestBody final Map<String, Boolean> cellMap) {

        int[][] matrix = new int[4][4];
        for (Entry<String, Boolean> entry : cellMap.entrySet()) {
            int x = entry.getKey().replace("cell", "").charAt(0) - '0' - 1;
            int y = entry.getKey().replace("cell", "").charAt(1) - '0' - 1;
            matrix[x][y] = entry.getValue() ? 1 : 0;
        }

        Meeting meeting = meetingsService.getById(id, Meeting.class);

        return true;
    }
}
