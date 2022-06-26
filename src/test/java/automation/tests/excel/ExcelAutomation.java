package automation.tests.excel;

import automation.pages.EmployeeDefaultPage;
import automation.pages.LoginPage;
import automation.utilities.ConfigurationReader;
import automation.utilities.Driver;
import automation.utilities.ExcelUtil;
import automation.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelAutomation {

    ExcelUtil excelUtil;

    List<Map<String,String>> testData;

    LoginPage loginPage = new LoginPage();
    EmployeeDefaultPage employeeDefaultPage=new EmployeeDefaultPage();
    public void logIn() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        ReusableMethods.waitFor(1);
        loginPage.loginDropdown.click();
        ReusableMethods.waitFor(1);
        try{
            loginPage.signOut.click();
            ReusableMethods.waitFor(1);
            loginPage.loginDropdown.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
            e.fillInStackTrace();
        }
        loginPage.signInButton.click();

    }
    @Test
    public void employeeLoginTest() throws InterruptedException, IOException {

        String path = "./src/test/java/resources/mysmoketestdata.xlsx";

        String sheetName="employee_login_info";

        excelUtil = new ExcelUtil(path,sheetName);

        testData=excelUtil.getDataList();

        for (Map<String,String> eachData :testData){

            logIn();
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(eachData.get("password"));
            ReusableMethods.waitFor(1);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);

            Assert.assertTrue(employeeDefaultPage.myOperationsDropdown.isDisplayed());

            ReusableMethods.getScreenshot("LoginSuccess");
        }
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}