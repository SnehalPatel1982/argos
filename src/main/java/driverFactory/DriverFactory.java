package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

   // public  WebDriver driver;

   public  static ThreadLocal<WebDriver> tslocal = new ThreadLocal<>();

    public WebDriver init_browser(String browser) {
        System.out.println("The browser name is == " + browser);
        System.out.println("This is driver factory page");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tslocal.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tslocal.set(new FirefoxDriver());
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            tslocal.set(new EdgeDriver());
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            tslocal.set(new OperaDriver());
        } else {
            WebDriverManager.iedriver().setup();
            tslocal.set(new InternetExplorerDriver());
        }

        getdriver().manage().window().maximize();
        getdriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getdriver().manage().deleteAllCookies();
        return getdriver();
    }

    public static WebDriver getdriver() {
        return tslocal.get();
    }
}
