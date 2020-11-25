package com.bfs.authserver;

import com.bfs.authserver.security.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {

        //test register get register token
        String spersonId = String.valueOf(2);
        System.out.println(JwtUtil.generateRegisterToken("signingKeyemployee", spersonId, "test2@1234.com"));

        SpringApplication.run(AuthServerApplication.class, args);
    }

}
