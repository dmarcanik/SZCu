package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpperMenuLoggedOut extends BasePage {

    public UpperMenuLoggedOut(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#neo-login")
    private WebElement loginBtn;

    public void clickLoginBtn() throws InterruptedException {
        click(loginBtn);
    }
}
