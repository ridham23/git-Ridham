package CommonUtil;

import Base.Base;
import Pages.TabContacts;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public  class Common extends Base {

  static   FileInputStream fis;
   static Workbook wb;
   static Sheet sheet;
    Object[][] obj;

    //@FindBy(xpath = ".//div[contains(@class,'ui head')]/text()[3]")  This webelemt will point to text directly will not get text value
@FindBy(xpath = ".//div[contains(@class,'ui head')]")
    WebElement TabName;
    public Common()
    {

        PageFactory.initElements(driver,this);


    }

    public Common(String Path) {
        try {
            PageFactory.initElements(driver, this);
             fis = new FileInputStream(Path);
            wb= WorkbookFactory.create(fis);
           String SheetName= prop.getProperty("Sheet");
sheet=wb.getSheet(SheetName);
            obj = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
    public static long pageloadtimeout = 20;
        public static long implicitwait = 10;

        public String GetTabTitle()
        {
            System.out.println("Getting Page Title");
            String Text=TabName.getText().toString();
            System.out.println("Tab title is "+ Text);
            return Text;
        }

        



        public Object[][] ExcelDataReader(String SheetNum) throws IOException {

     try
     {
         sheet =  wb.getSheet(SheetNum);

int rownum =sheet.getLastRowNum();
for(int i=0;i<rownum;i++) {
    for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
        obj[i][j] = sheet.getRow(i+1).getCell(j).toString();
        System.out.println(obj[i][j]);
    }
}


}
     catch(Exception e)
     {
         System.out.println("No FIlefound R");
     }
return obj;
        }

        public static void SelectDropDownValue(String DropDownName, String Value) throws InterruptedException {
            /*this method can be used only in case of select tags
           Select Drpdwn = new Select(driver.findElement(By.xpath(".//div[@name='"+DropDownName+"']")));
           Drpdwn.selectByVisibleText(Value);*/

            driver.findElement(By.xpath(".//div[@name='"+DropDownName+"']")).click();

            System.out.println("clicked");
driver.findElement(By.xpath(".//span[text()='"+Value+"']")).click();

        }



}
