package app.models;

import org.javalite.activejdbc.Model;

import java.util.List;

public class User extends Model {

    public User(){

    }

    public static User verifyLoginCredentials(String username, String password){
        List<User> user = User.findBySQL("SELECT * FROM users WHERE username = ? AND password = SHA2(?, 256)", username, password);
        if(user.size() > 0){
            return user.get(0);
        }
        else{
            return null;
        }
    }

    public Integer getGold() {
        return getInteger("gold");
    }

    public User setGold(int gold) {
        return this.setInteger("gold", gold);
    }
}
