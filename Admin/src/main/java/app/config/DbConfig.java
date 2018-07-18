package app.config;

import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;

public class DbConfig extends AbstractDBConfig {
    public void init(AppContext context) {
        configFile("/database.properties");
        environment("testenv", true).jndi("java:comp/env/jdbc/jes");
        environment("staging", true).jndi("java:comp/env/jdbc/jes");
        environment("production", true).jndi("java:comp/env/jdbc/jes");
    }
}