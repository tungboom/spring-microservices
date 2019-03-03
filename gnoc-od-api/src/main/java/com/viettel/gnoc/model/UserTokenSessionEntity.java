package com.viettel.gnoc.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author TungBoom
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_token_session")
public class UserTokenSessionEntity {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "token", nullable = false, unique = true, length = 500)
    private String token;

    @Column(name = "session_id", nullable = false, unique = true)
    private String sessionId;

    @Column(name = "expiry_time", nullable = false)
    private Long expiryTime;

    @Column(name = "created_time", insertable=true, updatable=false)
    private LocalDateTime createdTime;

    @Column(name = "updated_time", insertable=false, updatable=true)
    private LocalDateTime updatedTime;

    @PrePersist
    protected void onCreate() {
        createdTime = LocalDateTime.now();
        updatedTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTime = LocalDateTime.now();
    }

    public UserTokenSessionEntity(String username, String token, String sessionId, Long expiryTime) {
        this.username = username;
        this.token = token;
        this.sessionId = sessionId;
        this.expiryTime = expiryTime;
    }
}
