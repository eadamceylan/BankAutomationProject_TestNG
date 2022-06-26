package automation.tests;

import automation.pages.LoginPage;
import automation.utilities.ConfigurationReader;
import automation.utilities.Driver;
import automation.utilities.JSUtils;
import automation.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSUtilsTests {

    LoginPage loginPage = new LoginPage();
    @Test
    public void  scrollIntoViewTests(){

        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));

        WebElement pricingPlan= Driver.getDriver().findElement(By.xpath("//*[.='Pricing Plan']"));
        JSUtils.scrollIntoViewJS(pricingPlan);
    }

    @Test
    public void clickWithJSTest() {


        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(loginPage.loginDropdown);

        JSUtils.clickElementByJS(loginPage.signInButton);

    }

    @Test
    public void scrollDownThePage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        JSUtils.scrollDownByJS();
    }

    @Test
    public void flassTest(){

        LoginPage loginPage = new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        JSUtils.clickElementByJS(loginPage.loginDropdown);
        JSUtils.clickElementByJS(loginPage.signInButton);
        JSUtils.flash(loginPage.loginButton);
    }
}
