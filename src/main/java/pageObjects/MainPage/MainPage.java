package pageObjects.MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;
import pageObjects.MainPage.Lotteries.LotteryPage;

public class MainPage extends BasePage {

    @FindBy(css = "#lottery")
    WebElement lotteryPage;

    @FindBy(css = "#scrapper")
    WebElement scrapperPage;

    @FindBy(css = "#sport")
    WebElement sportPage;

    @FindBy(css = "#casino")
    WebElement casinoPage;

    @FindBy(css = "#fun")
    WebElement funPage;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LotteryPage clickToLotteryPage(){
        click(lotteryPage);
        return new LotteryPage(driver);
    }

    public ScrapperPage clickToScrapperPage(){
        click(scrapperPage);
        return new ScrapperPage(driver);
    }
    public SportPage clickToSportPage(){
        click(sportPage);
        return new SportPage(driver);
    }

    public CasinoPage clickToCasinoPage(){
        click(casinoPage);
        return new CasinoPage(driver);
    }

    public FunPage clickToFunPage(){
        click(funPage);
        return new FunPage(driver);
    }




}
