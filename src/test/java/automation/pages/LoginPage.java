package automation.pages;

import automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="account-menu")
    public WebElement loginDropdown;

    @FindBy(xpath = "(//*[text()='Sign in'])[1]")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Sign out']")
    public WebElement signOut;

    public void loginApplication(String userName, String pass){
        loginDropdown.click();
        signInButton.click();
        username.sendKeys(userName);
        password.sendKeys(pass);
        loginButton.click();

    }
}
