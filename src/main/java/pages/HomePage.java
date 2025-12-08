package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");

    public  HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickAuthenticationLink(){
        driver.findElement(formAuthenticationLink).click();
        //we should return handle to that page
        return new LoginPage(driver);
    }


}
