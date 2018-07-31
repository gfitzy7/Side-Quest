package app.controllers;

import org.javalite.activeweb.controllers.AbstractLesscController;

import java.io.File;

/**
 *
 * Created by igor on 4/29/14.
 */
public class BootstrapController extends AbstractLesscController {

    @Override
    protected File getLessFile() {
        return new File("src/main/webapp/less/bootstrap.less");
    }

}
