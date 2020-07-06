package Pages;

import Base.Base;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.sql.SQLOutput;

public class HomePage extends Base {

    TabContacts contactsTab;

@FindBy(xpath=".//span[contains(text(),'Ridh')]")
    WebElement BLogoName;
    @FindBy(xpath =".//span[contains(text(),'Home')]")
    WebElement BTabHome;
    @FindBy(xpath =".//span[contains(text(),'Calendar')]")
    WebElement BTabCalender;
    @FindBy(xpath =".//span[contains(text(),'Contacts')]")
    WebElement BTabContacts;
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }

    public TabContacts ClickContactsTab()
    {
        System.out.println("navigating to Contacts");
        Actions action = new Actions(driver);
        action.doubleClick(BTabContacts).perform();

        return new TabContacts();
    }
    public TabCalendar ClickCalendarTab()
    {
        System.out.println("navigating to Contacts");
        BTabCalender.click();
        return new TabCalendar();
    }
    public TabHome ClickHomepage()
    {
        System.out.println("Navigating HomeTab");
        BTabHome.click();
        return new TabHome();
    }
    public String GetTitle()
    {
        System.out.println("Getting Title");
        return driver.getTitle();

    }

    public String Validatename()
    {
        System.out.println("Getting Name on Homepage");
String Text = BLogoName.getText();
        System.out.println("Text is "+Text);
        return Text;
    }
}
