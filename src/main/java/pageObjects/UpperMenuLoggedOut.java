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

    @FindBy(css = "#neo-registration")
    private WebElement createAccBtn;

    @FindBy(css = "div.header-col div.main-menu")
    private WebElement hamburgerMenu;

    @FindBy(css = "div.header-col div.searching.searching--closed")
    private WebElement search;

    public void clickLoginBtn() {
        click(loginBtn);
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
