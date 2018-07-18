package app.services;

import app.models.AdminUser;

import java.io.Serializable;

public class AdminSession implements Serializable {

    private String sessionId;
    private long loginTime;

    private transient AdminUser user;
    private Long userId;

    public AdminSession(String sessionId, AdminUser user, long time){
        this.sessionId = sessionId;
        this.loginTime = time;

        this.user = user;
        this.userId = user.getLongId();
    }

    public AdminUser getAdminUser(){
        return (user == null ? (AdminUser) AdminUser.findById(userId) : user);
    }

}
