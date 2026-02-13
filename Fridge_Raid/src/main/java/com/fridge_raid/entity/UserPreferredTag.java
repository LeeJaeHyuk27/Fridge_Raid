package com.fridge_raid.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USER_PREFERRED_TAG")
public class UserPreferredTag {

    @EmbeddedId
    private UserPreferredTagId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserInfo user;

    @MapsId("tagId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID", nullable = false)
    private Tag tag;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;
}
