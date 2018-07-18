package app.filters;

import app.controllers.AbstractAppController;
import app.controllers.LoginController;
import app.services.AdminSession;
import org.javalite.activeweb.controller_filters.HttpSupportFilter;

public class AuthorizationFilter extends HttpSupportFilter {

    @Override
    public void before(){
        AdminSession session = (AdminSession) session(AbstractAppController.USER_SESSION);
        if(session == null || session().getId() == null){
            redirect(LoginController.class);
        }
    }

    @Override
    public void after(){

    }

}