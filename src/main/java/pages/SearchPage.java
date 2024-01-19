package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    public WebDriver driver;

    private By cookies = By.xpath("//button[@id='explicit-consent-prompt-accept']");

    private By searchtext = By.xpath("//input[@name=\"searchTerm\"]");

    private By searchbutton = By.xpath("//button[@class=\"_2mKaC\"]");


    private By labeltext = By.cssSelector(".styles__SearchTerm-sc-1haccah-1.eslAyR");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    System.out.println("This is search page ");
    }

    public void setCookies() {
        driver.findElement(cookies).click();
    }

    public void setSearchtext(String product) {
        driver.findElement(searchtext).sendKeys(product);
    }

    public void setSearchbutton() {
        driver.findElement(searchbutton).click();
    }

    public String setLabeltext() {

        String value = driver.findElement(labeltext).getText();
        return value;
    }

    public String setURL() {
        return driver.getCurrentUrl();
    }


}
