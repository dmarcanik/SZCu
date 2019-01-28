package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHeader extends BasePage {

    @FindBy(css = "#userName")
    private WebElement myAccount;

    @FindBy(css = "#myWagers")
    private WebElement myWagers;

    @FindBy(css = "#loggedInTime")
    private WebElement loggedInTime;


    public LoggedHeader(WebDriver driver) {
        super(driver);
    }

    public MyWagers clicktoMyWagers() {
        click(myWagers);
        return new MyWagers(driver);
    }

    public MyAccount clickToMyAcc() {
        click(myAccount);
        return new MyAccount(driver);
    }


}
