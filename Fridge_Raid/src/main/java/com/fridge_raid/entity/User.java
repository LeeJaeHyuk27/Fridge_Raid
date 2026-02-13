package com.fridge_raid.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "USER_INFO")
public class User {

	@Id
    @Column(name = "USER_ID", length = 50)
    private String userId;

    @Column(name = "PASSWORD_HASH", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "USER_NAME", nullable = false, length = 50)
    private String userName;

    @Column(name = "ADMIN_LEVEL", nullable = false)
    private Integer adminLevel;

    @Column(name = "JOIN_DATE", nullable = false)
    private LocalDateTime joinDate;
    
}
