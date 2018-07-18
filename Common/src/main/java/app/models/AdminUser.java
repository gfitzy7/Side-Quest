package app.models;

import org.javalite.activejdbc.Model;

import java.util.List;

public class AdminUser extends Model {

    public AdminUser(){

    }

    public static AdminUser verifyLoginCredentials(String username, String password){
        List<AdminUser> user = AdminUser.findBySQL("SELECT * FROM admin_users WHERE username = ? AND password = SHA2(?, 256)", username, password);
        if(user.size() > 0){
            return user.get(0);
        }
        else{
            return null;
        }
    }
}
