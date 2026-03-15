package com.fridge_raid.user.service;

import com.fridge_raid.entity.UserInfo;
import com.fridge_raid.user.dto.JoinDto;
import com.fridge_raid.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository UserRepository;
    private final PasswordEncoder passwordEncoder;

    public JoinService(UserRepository UserRepository, PasswordEncoder passwordEncoder) {
        this.UserRepository = UserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void join(JoinDto joinDto) {

        if (joinDto.userId() == null || joinDto.userId().trim().isEmpty()) {
            throw new IllegalArgumentException("아이디를 입력해주세요.");
        }

        if (joinDto.passwordHash() == null || joinDto.passwordHash().trim().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
        }

        if (joinDto.userName() == null || joinDto.userName().trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }

        if (UserRepository.existByUserId(joinDto.userId())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        UserInfo user = new UserInfo(
                joinDto.userId(),
                passwordEncoder.encode(joinDto.passwordHash()),
                joinDto.userName()
        );

        UserRepository.save(user);
    }
}