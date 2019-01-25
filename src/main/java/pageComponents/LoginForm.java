package pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class LoginForm extends BasePage {

    @FindBy(css = "#user")
    private WebElement user;

    @FindBy(css = "#password")
    private WebElement password;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void fillUser(String username) throws InterruptedException {
        user.sendKeys(username);
    }
    public void fillPassword(String pass) throws InterruptedException {
        password.sendKeys(pass);
    }
}
