package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {

    @Before("@ui")
    public void setUpUI() {
        Driver.getDriver();
    }

    @After("@ui")
    public void tearDownUI() {
        Driver.closeDriver();
    }
}