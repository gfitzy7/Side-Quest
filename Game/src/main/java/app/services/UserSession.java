package app.services;

import app.models.User;

import java.io.Serializable;

public class UserSession implements Serializable {

    private String sessionId;
    private long loginTime;

    private transient User user;
    private Long userId;

    public UserSession(String sessionId, User user, long time){
        this.sessionId = sessionId;
        this.loginTime = time;

        this.user = user;
        this.userId = user.getLongId();
    }

    public User getUser(){
        return (user == null ? (User) User.findById(userId) : user);
    }

}
