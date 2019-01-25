package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageComponents.LoginForm;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#neo-login")
    private WebElement loginBtn;

    @FindBy(css = "#neo-registration")
    private WebElement createAccBtn;

    @FindBy(css = "div.header-col div.main-menu")
    private WebElement hamburgerMenu;

    @FindBy(css = "div.header-col div.searching.searching--closed")
    private WebElement search;

    public LoginForm clickLoginBtn() {
        click(loginBtn);
        return new LoginForm(driver);
    }

    public void clickCreateAccBtn() {
        click(createAccBtn);
    }

    public void clickHamburgerMenu() {
        click(hamburgerMenu);
    }

    public void clickSearch() {
        click(search);
    }

}
