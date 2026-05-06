package com.fridge_raid.user.controller;

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
@CrossOrigin(origins = "http://localhost:3000")
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
    
}
