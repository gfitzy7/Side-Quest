package app.controllers;

import app.models.User;
import org.javalite.activeweb.annotations.POST;

public class HomeController extends AbstractAppController {

    @POST
    public void test(){
        respond("ping").status(200);
    }

    @POST
    public void purchaseGold() {
        User user = getUser();
        if(user != null) {
            int goldToBuy = 5;
            int currentGold = user.getGold();
            user.setGold(currentGold + goldToBuy).saveIt();
            respond(goldToBuy + " gold was purchased!").status(200);
        }
    }

}