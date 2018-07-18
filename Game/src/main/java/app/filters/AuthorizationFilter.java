package app.filters;

import app.controllers.AbstractAppController;
import app.controllers.LoginController;
import app.services.UserSession;
import org.javalite.activeweb.controller_filters.HttpSupportFilter;

public class AuthorizationFilter extends HttpSupportFilter {

    @Override
    public void before(){
        UserSession session = (UserSession) session(AbstractAppController.USER_SESSION);
        if(session == null || session().getId() == null){
            redirect(LoginController.class);
        }
    }

    @Override
    public void after(){

    }

}