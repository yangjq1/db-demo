package app.demo;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author Else
 */
public class DbDemoServiceApp extends App {
    @Override
    protected void initialize() {
        http().httpPort(9012);
        http().httpsPort(9072);
        load(new SystemModule("sys.properties"));
        load(new CustomerModule());
        load(new ProductModule());
    }
}
