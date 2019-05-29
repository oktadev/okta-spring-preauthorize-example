package com.okta.preauthorize.Application;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserInfoController {
    
    @RequestMapping("/oauthinfo")
    @ResponseBody
    public String oauthUserInfo(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                              @AuthenticationPrincipal OAuth2User oauth2User,
                                Principal principal) {
        return
            "User Name: " + oauth2User.getName() + "<br/>" +
                "User Authorities: " + oauth2User.getAuthorities() + "<br/>" +
                "Client Name: " + authorizedClient.getClientRegistration().getClientName() + "<br/>" +
                this.prettyPrintAttributes(oauth2User.getAttributes());
    }

    private String prettyPrintAttributes(Map<String, Object> attributes) {
        String acc = "User Attributes: <br/><div style=padding-left:20px;>";
        for (String key : attributes.keySet()){
            Object value = attributes.get(key);
            acc += "<div>"+key + ":&nbsp" + value.toString() + "</div>";
        }
        return acc + "</div>";
    }
}
