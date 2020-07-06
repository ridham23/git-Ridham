package TestCases;

import Base.Base;
import CommonUtil.Common;
import Pages.HomePage;
import Pages.Launch;
import Pages.Login;
import Pages.TabContacts;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.PriorityQueue;

public class HomepageTest extends Base {
    public HomepageTest()
    {
        super();
    }
    Launch launch;
    Login login;
    HomePage homepage;
    TabContacts tabContacts;
    Common UtilObj;

    @BeforeClass
    public void setup()
    {

        initialization();
        launch= new Launch();
login = launch.loginClick();
homepage = login.authenticate();
String excelpath=prop.getProperty("ExcelPath");
UtilObj = new Common(excelpath);
    }
    @Test(priority=5)
public void ValidateTitle()
{
    String title = homepage.GetTitle();
    System.out.println("Title is "+title);
    Assert.assertEquals(title,"Cogmento CRM","Homepage Title not match");
}
    @Test(priority=6)
public void Validatename()
    {
homepage.Validatename();

    }


    @Test(priority=7)
public void NavigateTabCotancts() throws InterruptedException {
    Thread.sleep(3000);
   tabContacts = homepage.ClickContactsTab();

}
    @Test(priority=8)
public void GetTabName()  {
    String Title = UtilObj.GetTabTitle();
    System.out.println("Title is "+UtilObj.GetTabTitle());

}

   /* @Test(priority=9)
      public void ClickCheckBox()
{
    tabContacts.ClickCheckbox("ridh shar");
}
    @Test(priority = 9)
           public void getview() throws InterruptedException {
       tabContacts.SelectView();
   }


@DataProvider
public Object[][] getTestData() throws IOException {
    Object data[][]=UtilObj.ExcelDataReader("Sheet1");
    return data;
}
    @Test(priority=10)
     public void SelectNew()
     {
         tabContacts.SelectNew();
     }
@Test(priority = 11,dataProvider = "getTestData")
        public void CreateContact(String FName,String LName,String Dep,String DrpDwn,String DrpdwnValue) throws InterruptedException {
    try {
        tabContacts.SelectNew();
        tabContacts.EnterNewContValues(FName,LName,Dep,DrpDwn,DrpdwnValue);
       tabContacts.ClickSave();
        Thread.sleep(5000);
        homepage.ClickContactsTab();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}*/

    @AfterClass

    public void quit()
    {
        System.out.println("Quit");
        //driver.quit();
    }

}
