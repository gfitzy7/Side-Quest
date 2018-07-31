package app.controllers;

import org.javalite.activeweb.controllers.AbstractLesscController;

import java.io.File;

/**
 * @author shanef on 7/30/18.
 */
public class BootstrapController extends AbstractLesscController {

    @Override
    protected File getLessFile() {
        return new File("src/main/webapp/less/bootstrap.less");
    }

}
