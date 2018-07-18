package app.controllers;

import org.javalite.activeweb.annotations.POST;

public class LoginController extends AbstractAppController {

    public void index(){

    }

    @POST
    public void attemptLogin(){
        String username = param("username");
        String password = param("password");
        if(login(username, password)){
            redirect(HomeController.class);
        }
        else{
            redirectToReferrer();
        }
    }

}