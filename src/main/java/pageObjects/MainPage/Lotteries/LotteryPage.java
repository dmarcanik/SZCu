package pageObjects.MainPage.Lotteries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.MainPage.Lotteries.Eurojackpot.EurojackpotPage;
import pageObjects.MainPage.Lotteries.Euromiliony.EuromilionyPage;
import pageObjects.MainPage.Lotteries.Kasicka.KasickaPage;
import pageObjects.MainPage.Lotteries.Keno.KenoPage;
import pageObjects.MainPage.Lotteries.RK.RychlekackyPage;
import pageObjects.MainPage.Lotteries.S10.S10Page;
import pageObjects.MainPage.Lotteries.SazkaMobil.SazkamobilPage;
import pageObjects.MainPage.Lotteries.Sportka.SportkaPage;
import pageObjects.MainPage.Lotteries.TOTO.TotosazkaPage;
import pageObjects.MainPage.MainPage;

public class LotteryPage extends MainPage {

    @FindBy(css = "#sportka-banner")
    WebElement sportkaPage;

    @FindBy(css = "#eurojackpot-banner")
    WebElement eurojackpotPage;

    @FindBy(css = "#stastnych10-banner")
    WebElement stastnych10Page;

    @FindBy(css = "#keno-banner")
    WebElement kenoPage;

    @FindBy(css = "#euromiliony-banner")
    WebElement euromilionyPage;

    @FindBy(css = "#kasicka-banner")
    WebElement kasickaPage;

    @FindBy(css = "#sazkamobil-banner")
    WebElement sazkamobilPage;


    @FindBy(css = "#toto-banner")
    WebElement totoPage;

    @FindBy(css = "#rychlekacky-banner")
    WebElement rychlekackyPage;


    public LotteryPage(WebDriver driver) {
        super(driver);
    }

    public EurojackpotPage clickToEurojackpot(){
        click(eurojackpotPage);
        return new EurojackpotPage(driver);
    }

    public SportkaPage clickToSportka(){
        click(sportkaPage);
        return new SportkaPage(driver);
    }

    public S10Page clickToS10(){
        click(stastnych10Page);
        return new S10Page(driver);
    }
    public KenoPage clickToKeno(){
        click(kenoPage);
        return new KenoPage(driver);
    }
    public EuromilionyPage clickToEuromiliony(){
        click(euromilionyPage);
        return new EuromilionyPage(driver);
    }
    public KasickaPage clickToKasicka(){
        click(kasickaPage);
        return new KasickaPage(driver);
    }
    public SazkamobilPage clickToSazkaMobil(){
        click(sazkamobilPage);
        return new SazkamobilPage(driver);
    }

    public TotosazkaPage clickToToto(){
        click(totoPage);
        return new TotosazkaPage(driver);
    }
    public RychlekackyPage clickToRychleKacky(){
        click(rychlekackyPage);
        return new RychlekackyPage(driver);
    }
}
