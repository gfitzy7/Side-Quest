package app.controllers;

import app.models.AdminUser;
import app.services.AdminSession;
import org.javalite.activeweb.AppController;

public abstract class AbstractAppController extends AppController {

    public static final String USER_SESSION = "user_session";
    public static final String USER_NAME = "user_name";
    public static final String USER_ID = "user_id";

    protected boolean login(String username, String password){
        AdminUser user = AdminUser.verifyLoginCredentials(username, password);
        if(user == null){
            return false;
        }

        AdminSession session = new AdminSession(session().getId(), user, System.currentTimeMillis());
        session(USER_SESSION, session);
        session(USER_NAME, user.getString("username"));
        session(USER_ID, user.getLongId());
        return true;
    }

    protected void logout() {
        logInfo("LOGOUT");
        AdminSession userSession = getUserSession();
        if (userSession != null) {
            session().invalidate();
        } else {
            session().remove(USER_ID);
        }

        redirect();
    }

    public AdminSession getUserSession(){
        return (AdminSession) session(USER_SESSION);
    }

}