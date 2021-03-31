package com.okta.preauthorize.application;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome home!";
    }

    @RequestMapping("/restricted")
    @ResponseBody
    @PreAuthorize("hasAuthority('Admin')")
    public String restricted() {
        return "You found the secret lair!";
    }

}
