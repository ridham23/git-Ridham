package Pages;

import Base.Base;
import CommonUtil.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabContacts extends Base {

HomePage homepage;
    @FindBy(xpath=".//div[contains(@name,'view')]")
    WebElement ViewDropdown;
    @FindBy(xpath = ".//button[text()='New']")
    WebElement ButtonNew;
    @FindBy(name="first_name")
    WebElement TextFirstName;
    @FindBy(name="last_name")
    WebElement TextLastName;
    @FindBy(name="department")
    WebElement TextDepartment;
    @FindBy(xpath = ".//button[text()='Save']")
    WebElement ButtonSave;
    @FindBy(xpath="")
    WebElement DrpDwnCategory;

    public TabContacts()
    {
        PageFactory.initElements(driver,this);
    }
    public void ClickCheckbox(String name)
    {
        driver.findElement(By.xpath(".//td[contains(text(),'"+name+"')]/parent::tr//div[contains(@class,'checkbox')]")).click();

    }
    public void SelectView() throws InterruptedException {
        Common.SelectDropDownValue("view","Default View");
    }
    public void SelectNew()
    {
        System.out.println("Click on New Button");
        ButtonNew.click();
    }
    public void EnterNewContValues(String FName,String LName,String Dep,String DrpDwn,String DrpdwnValue) throws InterruptedException {
        System.out.println("Enter "+FName+" and "+LName+"");
       TextFirstName.sendKeys(FName);
       TextLastName.sendKeys(LName);
        System.out.println("Setting Department as "+Dep);
        //TextDepartment.sendKeys(Dep);
        System.out.println("Select "+ DrpDwn +" value as "+DrpdwnValue);
        Common.SelectDropDownValue(DrpDwn,DrpdwnValue);

    }
    public void ClickSave()
    {
        System.out.println("Clicking Save");
      ButtonSave.click();
      //  return  homepage;
        
    }


}
