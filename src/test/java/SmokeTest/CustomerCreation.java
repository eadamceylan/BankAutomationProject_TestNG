package SmokeTest;


import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import automation.pages.CreateCustomerPage;
import automation.pages.EmployeeDefaultPage;
import automation.pages.LoginPage;
import automation.utilities.ConfigurationReader;
import automation.utilities.Driver;
import automation.utilities.ReusableMethods;

import java.io.IOException;

public class CustomerCreation {


    LoginPage loginPage = new LoginPage();
    EmployeeDefaultPage employeeDefaultPage = new EmployeeDefaultPage();
    CreateCustomerPage createCustomerPage = new CreateCustomerPage();
    @Test
    public void createCustomerAsEmployee() throws IOException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        loginPage.loginApplication("gino.wintheiser","%B6B*q1!TH");
        employeeDefaultPage.myOperationsDropdown.click();
        employeeDefaultPage.manageCustomers.click();
        createCustomerPage.createANewCustomer.click();
        createCustomerPage.firstname.sendKeys("Testfirst");
        createCustomerPage.lastname.sendKeys("Testlast");
        createCustomerPage.middleInitial.sendKeys("T");
        createCustomerPage.email.sendKeys("test@gmail.com");
        createCustomerPage.mobilePhoneNumber.sendKeys("111-111-1111");
        createCustomerPage.phoneNumber.sendKeys("111-111-1111");
        createCustomerPage.zipCode.sendKeys("11111");
        createCustomerPage.address.sendKeys("Test Address 123");
        createCustomerPage.city.sendKeys("TestCity");
        createCustomerPage.ssn2.sendKeys("111-11-1111");
        new Select(createCustomerPage.countryDropdown).selectByVisibleText("USA");
        createCustomerPage.state.sendKeys("Texas");
        new Select(createCustomerPage.userDrop).selectByIndex(2);
        new Select(createCustomerPage.countryDropdown).selectByIndex(2);
        createCustomerPage.zelleEnrolledCheckbox.click();
        createCustomerPage.saveButton.click();

        ReusableMethods.getScreenshot("CustomerCreated");

    }
}