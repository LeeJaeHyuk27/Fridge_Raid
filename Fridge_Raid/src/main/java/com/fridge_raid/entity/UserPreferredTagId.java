package com.fridge_raid.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserPreferredTagId implements Serializable {
    @Column(name = "USER_ID", length = 50)
    private String userId;

    @Column(name = "TAG_ID")
    private Long tagId;

    public UserPreferredTagId() {}
    public UserPreferredTagId(String userId, Long tagId) {
        this.userId = userId;
        this.tagId = tagId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPreferredTagId)) return false;
        UserPreferredTagId that = (UserPreferredTagId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(tagId, that.tagId);
    }
    @Override public int hashCode() { return Objects.hash(userId, tagId); }
}
