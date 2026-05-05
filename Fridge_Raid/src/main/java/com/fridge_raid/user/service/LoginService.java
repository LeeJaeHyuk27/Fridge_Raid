package com.fridge_raid.user.service;

import com.fridge_raid.entity.UserInfo;
import com.fridge_raid.user.dto.LoginDto;
import com.fridge_raid.user.repository.LoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(LoginDto loginDto) {

        if (loginDto.userId() == null || loginDto.userId().trim().isEmpty()) {
            throw new IllegalArgumentException("아이디를 입력해주세요.");
        }

        if (loginDto.passwordHash() == null || loginDto.passwordHash().trim().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
        }

        UserInfo user = loginRepository.findByUserId(loginDto.userId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        if (!passwordEncoder.matches(loginDto.passwordHash(), user.getPasswordHash())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return "로그인 성공";
    }
}