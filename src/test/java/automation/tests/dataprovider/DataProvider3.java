package automation.tests.dataprovider;

import automation.pages.EmployeeDefaultPage;
import automation.pages.LoginPage;
import automation.utilities.ConfigurationReader;
import automation.utilities.Driver;
import automation.utilities.ExcelUtil;
import automation.utilities.ReusableMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3 {

    @DataProvider(name="employeeInfo")
    public Object[][] getData(){

        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName="employee_login_info";
        ExcelUtil excelUtil = new ExcelUtil(path,sheetName);

        Object[][] employeeCredentials=excelUtil.getDataArrayWithoutFirstRow();

        return employeeCredentials;
    }

    LoginPage loginPage;
    EmployeeDefaultPage employeeDefaultPage;
    public void logIn() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        loginPage=new LoginPage();
        employeeDefaultPage=new EmployeeDefaultPage();
        ReusableMethods.waitFor(1);
        loginPage.loginDropdown.click();
        ReusableMethods.waitFor(1);
        try{
            loginPage.signOut.click();
            ReusableMethods.waitFor(1);
            loginPage.loginDropdown.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){

        }
        loginPage.signInButton.click();
    }


    @Test(dataProvider = "employeeInfo")
    public void employeeLogin(String userName, String password) throws InterruptedException {

        logIn();

        loginPage.username.sendKeys(userName);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();
    }

}