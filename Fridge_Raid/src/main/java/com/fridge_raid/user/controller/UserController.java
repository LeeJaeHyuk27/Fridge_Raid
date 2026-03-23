package com.fridge_raid.user.controller;

import java.util.*;

import com.fridge_raid.user.dto.JoinDto;
import com.fridge_raid.user.service.JoinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final JoinService joinService;

    public UserController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto) {
        joinService.join(joinDto);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
    
    
}
