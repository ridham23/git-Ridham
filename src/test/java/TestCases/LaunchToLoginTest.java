package TestCases;

import Base.Base;
import Pages.HomePage;
import Pages.Launch;
import Pages.Login;
import org.apache.log4j.Priority;
import org.testng.Assert;
import org.testng.annotations.*;

public class LaunchToLoginTest extends Base {
Launch launch;
Login login;
HomePage homePage;
    public LaunchToLoginTest()
    {
        super();
    }
    @BeforeClass
    public void setup()
    {
        initialization();
        launch= new Launch();
    }
    @Test(priority=1)
public void loginpageTitleTest()
{
   String title = launch.validateHomepage();
   System.out.println(title);
}
    @Test(priority=2)
public void crmLogoImageTest() throws InterruptedException {
    Thread.sleep(5000);
    boolean b=launch.validateCRMImage();
    Assert.assertEquals(true,b);
}
    @Test(priority=3)
public void loginClick() throws InterruptedException {
    Thread.sleep(5000);
   login=launch.loginClick();

}
    @Test(priority=4)
public void login() throws InterruptedException {
    Thread.sleep(5000);
    login.authenticate();

}
    @AfterClass
    public void teardown()
    {
        System.out.println("doing nothing");
        //driver.quit();
    }

}
