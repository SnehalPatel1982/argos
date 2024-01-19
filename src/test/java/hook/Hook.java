package hook;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.Properties;

public class Hook {

    private DriverFactory driverFactory;
    private ConfigReader configReader;

    private WebDriver driver;
    private Properties prop;

    
    @Before(order = 0)
    public void getProperty() throws IOException {
        System.out.println("This is hook page");
        configReader = new ConfigReader();
        prop = configReader.init_reader();
    }

    @Before(order = 1)
    public void openbrowser() {
        String browswername = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_browser(browswername);
    }

    @After(order = 0)
    public void teardown()
    {
        driver.close();
    }


}
