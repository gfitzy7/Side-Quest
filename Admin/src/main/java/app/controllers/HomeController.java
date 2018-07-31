package app.controllers;

import org.javalite.activeweb.annotations.GET;

public class HomeController extends AbstractAppController {

    public void index(){
        view("username", session().get(AbstractAppController.USER_NAME));
    }

}