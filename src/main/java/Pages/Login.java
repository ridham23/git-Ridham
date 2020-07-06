package Pages;

import Base.Base;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;

public class Login extends Base {
    @FindBy(xpath=".//input[contains(@placeholder,'E-mail')]")
            @CacheLookup //stores data in cache
    WebElement TextUsername;
    @FindBy(xpath=".//input[contains(@placeholder,'Password')]")
    WebElement TextPassword;
    @FindBy(xpath=".//div[contains(@class,'submit button')]")
    WebElement ButtonLogin;

    public Login()
    {
        PageFactory.initElements(driver,this);
    }
    public HomePage authenticate()
    {
        System.out.println("trying to login");
        TextUsername.sendKeys("ridham23@gmail.com");
        TextPassword.sendKeys("Punjab@321");
        ButtonLogin.click();
        return new HomePage();
    }

}
