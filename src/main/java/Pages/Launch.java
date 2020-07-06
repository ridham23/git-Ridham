package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Launch extends Base {

    @FindBy(xpath = ".//a[contains(@class,'primary btn')]/span[text()='Log In']")
    WebElement BtnLogin;
@FindBy(xpath = ".//a[contains(@title,'free crm home')][1]")
WebElement CRMLogo;
    public Launch()
    {
        PageFactory.initElements(driver,this);
    }
    public String validateHomepage()
    {
       return driver.getTitle();
    }
    public  boolean validateCRMImage()
    {
        return CRMLogo.isDisplayed();
    }
    public Login loginClick()
    {
        BtnLogin.click();
        return new Login();
    }

}
