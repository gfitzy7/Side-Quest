package app.controllers;

import org.javalite.activeweb.annotations.POST;

public class LoginController extends AbstractAppController {

    @POST
    public void attemptLogin(){
        String username = param("username");
        String password = param("password");
        if(login(username, password)){
            respond(session().getId());
        }
        else{
            respond("Unable to log in.").contentType("text/plain").statusCode(401);
        }
    }

}