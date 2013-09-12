package cepkeliu.robocop.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cepkeliu.robocop.model.Meeting;
import cepkeliu.robocop.service.MeetingsService;

@Controller
public class PlayerSignupController {

    @Autowired
    private MeetingsService meetingsService;

    @ModelAttribute("selection")
    private SignUp createSelection() {
        SignUp sel = new SignUp();
        sel.setMeetingId("new");
        return sel;
    }

    @RequestMapping("/")
    public String index(final ModelMap map, @ModelAttribute("signUp") final SignUp signUp,
            @CookieValue(value = "byngoPlayerName", required = false) final String cookiePlayerName) {

        if (signUp.getPlayerName() == null) {
            signUp.setPlayerName(cookiePlayerName);
        }
        if (signUp.getMeetingId() == null) {
            signUp.setMeetingId("new");
        }
        map.put("meetings", meetingsService.getAll());

        return "signup";
    }
    
    private boolean empty(final String str) {
        return str == null || str.trim().isEmpty();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String start(@ModelAttribute("signUp") final SignUp signUp, final BindingResult result, final HttpServletResponse response) {

        if (empty(signUp.getPlayerName())) {
            result.rejectValue("playerName", "emptyPlayerName", "Įveskite žaidėjo vardą");
            return "signup";
        }
        
        String meetingId = signUp.getMeetingId();
        
        if ("new".equals(signUp.getMeetingId())) {
            if (empty(signUp.getMeetingName())) {
                result.rejectValue("meetingName", "emptyMeetingName", "Įveskite meetingo pavadinimą!");
                return "signup";
            }
            
            Meeting meeting = new Meeting();    
            meeting.setCreatedOn(new Date());
            meeting.setName(signUp.getMeetingName().trim());
            
            meetingsService.save(meeting, Meeting.class);
            meetingId = meeting.getId().toString();
        }
        
        response.addCookie(new Cookie("byngoPlayerName", signUp.getPlayerName()));

        return "redirect:game/" + meetingId;
    }
}
