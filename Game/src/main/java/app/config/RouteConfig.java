package app.config;

import app.controllers.LoginController;
import org.javalite.activeweb.AbstractRouteConfig;
import org.javalite.activeweb.AppContext;

public class RouteConfig extends AbstractRouteConfig {
    public void init(AppContext appContext) {
        route("/").to(LoginController.class);
    }
}