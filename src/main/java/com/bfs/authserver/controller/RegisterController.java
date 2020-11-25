package com.bfs.authserver.controller;

import com.bfs.authserver.dao.UserDAO;
import com.bfs.authserver.pojo.User;
import com.bfs.authserver.security.CookieUtil;
import com.bfs.authserver.security.JwtUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    UserDAO userDAO;

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKeyemployee";


    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(HttpServletResponse httpServletResponse, String username, String password, String registerToken, String redirect, Model model){

        if(registerToken == null)

        if (username == null || password == null || registerToken == null){
            model.addAttribute("error", "Invalid username, password or register token!");
            return "register";
        }

        String spersonId = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(registerToken).getBody().getSubject();

        String email = (String) Jwts.parser().setSigningKey(signingKey).parseClaimsJws(registerToken).getBody().get("email");
        if(!spersonId.matches("\\d+") || email == null){
            model.addAttribute("error", "Invalid register token!");
            return "register";
        }

        Integer personId = Integer.parseInt(spersonId);

        User user = new User();
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setPersonId(personId);

        userDAO.createUser(user);

        String roleName = userDAO.getRoleByUser(user).getRoleName();

        String token = JwtUtil.generateToken(signingKey, username, user.getEmail(), user.getPersonId(), user.getCreateDate(), user.getModificationDate(), roleName);
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

        return "redirect:" + redirect;
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletResponse httpServletResponse, String username, String redirect, Model model){
//        CookieUtil.clear(httpServletResponse, username);
//        return "redirect:" + redirect;
//    }
}
