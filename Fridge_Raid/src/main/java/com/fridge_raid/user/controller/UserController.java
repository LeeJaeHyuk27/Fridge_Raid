package com.fridge_raid.user.controller;

import com.fridge_raid.entity.UserInfo;
import com.fridge_raid.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {
	
	private final UserRepository userRepository;

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody UserInfo user) {

        // PK 중복 체크
        if (userRepository.existsById(user.getUserId())) {
            throw new RuntimeException("이미 존재하는 USER_ID 입니다.");
        }

        // 서버에서 직접 세팅해야 할 값
        //user.setJoinDate(LocalDateTime.now());

        userRepository.save(user);

        return "CREATED: " + user.getUserId();
    }

    // ✅ 삭제 (DELETE /users/{userId})
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String userId) {
        userRepository.deleteById(userId);
    }
}
