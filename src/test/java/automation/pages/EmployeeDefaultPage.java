package automation.pages;

import automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDefaultPage {

    public EmployeeDefaultPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="entity-menu")
    public WebElement myOperationsDropdown;

    @FindBy(xpath = "//span[.='Manage Customers']")
    public WebElement manageCustomers;
}
