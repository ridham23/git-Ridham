package Base;

import CommonUtil.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
     public static Properties prop;

    public Base() {
        try {
            prop = new Properties();

            FileInputStream ip = new FileInputStream("C:\\Users\\ridha\\Documents\\Intellij\\src\\main\\java\\config\\config.properties");
            prop.load(ip);
            System.out.println(ip.toString());
        }
        catch (FileNotFoundException e) {

            System.out.println("File Not found");
        }
            catch(IOException e)
            {
e.printStackTrace();
            }

        }

        public static void initialization()
        {

String BrowserName = prop.getProperty("browser");
            System.out.println(BrowserName);
if(BrowserName.equals("chrome"))
{
System.setProperty("webdriver.chrome.driver","C:\\Users\\ridha\\Documents\\Intellij\\chromedriver.exe");
driver=new ChromeDriver();
}
else
{
    System.out.println("error found");
}
    driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(Common.pageloadtimeout, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

driver.get(prop.getProperty("url"));

        }
}
