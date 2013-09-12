package cepkeliu.robocop.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

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
            @CookieValue(value = "byngoPlayerName", required = false) final String cookiePlayerName) throws UnsupportedEncodingException {

        if (signUp.getPlayerName() == null) {
            signUp.setPlayerName(URLDecoder.decode(cookiePlayerName, "UTF-8"));
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
    public String start(final ModelMap map, @ModelAttribute("signUp") final SignUp signUp, final BindingResult result,
            final HttpServletResponse response, final WebRequest request, final SessionStatus sessionStatus) throws UnsupportedEncodingException {

        if (empty(signUp.getPlayerName())) {
            result.rejectValue("playerName", "emptyPlayerName", "Įveskite žaidėjo vardą");
            map.put("meetings", meetingsService.getAll());
            return "signup";
        }
        
        Long meetingId;
        if ("new".equals(signUp.getMeetingId())) {
            if (empty(signUp.getMeetingName())) {
                result.rejectValue("meetingName", "emptyMeetingName", "Įveskite meetingo pavadinimą!");
                map.put("meetings", meetingsService.getAll());
                return "signup";
            }

            meetingId =
                    meetingsService
                            .createNewMeeting(signUp.getMeetingName(), signUp.getPlayerName());
        } else {
            Long id = Long.parseLong(signUp.getMeetingId());
            meetingId = meetingsService.attachPlayerToMeeting(id, signUp.getPlayerName());
        }
        
        Cookie userCookie = new Cookie("byngoPlayerName", URLEncoder.encode(signUp.getPlayerName(), "UTF-8"));
        userCookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(userCookie);
        sessionStatus.setComplete();
        request.setAttribute("player", signUp.getPlayerName(), RequestAttributes.SCOPE_SESSION);

        return "redirect:game/" + meetingId;
    }
}
