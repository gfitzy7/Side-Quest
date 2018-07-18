package app.controllers;

import app.models.User;
import app.services.UserSession;
import org.javalite.activeweb.AppController;

public abstract class AbstractAppController extends AppController {

    public static final String USER_SESSION = "user_session";
    public static final String USER_NAME = "user_name";
    public static final String USER_ID = "user_id";

    protected boolean login(String username, String password){
        User user = User.verifyLoginCredentials(username, password);
        if(user == null){
            return false;
        }

        UserSession session = new UserSession(session().getId(), user, System.currentTimeMillis());
        session(USER_SESSION, session);
        session(USER_NAME, user.getString("username"));
        session(USER_ID, user.getLongId());
        return true;
    }

    protected void logout() {
        logInfo("LOGOUT");
        UserSession userSession = getUserSession();
        if (userSession != null) {
            session().invalidate();
        } else {
            session().remove(USER_ID);
        }

        redirect();
    }

    public UserSession getUserSession(){
        return (UserSession) session(USER_SESSION);
    }

}