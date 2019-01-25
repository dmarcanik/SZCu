package pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class MyWagers extends BasePage {

    @FindBy(css = "#wager-list")
    private WebElement wagerList;

    public MyWagers(WebDriver driver) {
        super(driver);
    }
}
