package com.fridge_raid.user.controller;

import java.io.Console;
import java.util.*;

import com.fridge_raid.user.dto.JoinDto;
import com.fridge_raid.user.dto.LoginDto;
import com.fridge_raid.user.service.JoinService;
import com.fridge_raid.user.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    private final JoinService joinService;
    private final LoginService loginService;
    
    public UserController(JoinService joinService, LoginService loginService) {
        this.joinService = joinService;
        this.loginService = loginService;
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto) {
        joinService.join(joinDto);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto, HttpSession session) {
        return loginService.login(loginDto, session);
    }
    
    @GetMapping("/userCheck")
    public Map<String, Object> getLoginUser(HttpSession session) {

        Object user = session.getAttribute("loginUser");
        
        Map<String, Object> result = new HashMap<>();
        
        result.put("user", user);

        System.out.println(session.getId());
        return result;
    }
    
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "로그아웃 완료";
    }
}
