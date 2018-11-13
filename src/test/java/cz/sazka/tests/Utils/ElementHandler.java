package cz.sazka.tests.Utils;

import cz.sazka.tests.Steps.Hook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ElementHandler {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    public static WebElement findCmd(String target) {
        List<WebElement> cmds = ElementHandler.findCmds(target);

        return cmds.get(0);
    }

    private static List<WebElement> findCmds(String target) {
        waitElementLoadedBy(getIdBy(target));

        List<WebElement> elements = webDriver.findElements(By.cssSelector(Helpers.getIdCss(target)));

        if (elements.size() == 0) {
            String error = "CMD " + target + " not found. Check spelling and watch for capital letters";
            log.error(error);

            throw new InvalidParameterException(error);
        }

        return elements;
    }

    public static void clickCmd(WebElement element) {
        waitPageToBeLoaded();
        webDriverWait().until((ExpectedConditions.elementToBeClickable(element)));
        element.click();
        waitPageToBeLoaded();


    }

    public static WebDriverWait webDriverWait (){
        return new WebDriverWait(webDriver,30);
    }

    public static void waitPageToBeLoaded(){
        List<String> tagSelectors = Helpers.GetLoadingCsss();
        List<ExpectedCondition<WebElement>> expected = tagSelectors.stream().map(selector -> ExpectedConditions.elementToBeClickable(By.cssSelector(selector))).collect(Collectors.toList());
        ExpectedCondition[] expectedConditions = expected.toArray(new ExpectedCondition[expected.size()]);
        webDriverWait().until(ExpectedConditions.or(expectedConditions));
        if (loaderActive()){
            waitLoadingComplete();
        }
        waitTobeLoaded();
    }

    private static void waitTobeLoaded(){
        webDriverWait().until(ExpectedConditions.presenceOfElementLocated(getIdBy(Helpers.locatorMap("loadingScreen"))));
    }
    public static void waitToBeLoggedIn(){
        webDriverWait().until(ExpectedConditions.presenceOfElementLocated(getBy(Helpers.getLoggedInCss())));
    }
    public static void waitToBeLoggedOut(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable((getBy(Helpers.getLoggedOutCss()))));
        webDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(getBy(Helpers.getClassCss("mwc-modal-backdrop mwc-fade mwc-in"))));

        waitPageToBeLoaded();
    }
    private static void waitLoadingComplete (){
        webDriverWait().until(ExpectedConditions.not(ExpectedConditions.attributeContains(webDriver.findElement(By.tagName("div")),"class","loading")));
    }

    public static void acceptConsent (){
        WebElement element = ElementHandler.getConsentCssElement();
        if (element.isDisplayed()){
            element.findElement(By.cssSelector("[class=agree]")).click();

        }
    }



    public static boolean isLoggoutActive(){
        try {
            ElementHandler.getClasCssElement(Helpers.locatorMap("logout"));
            return true;

        }catch (NoSuchElementException ignored){
            return false;
        }
    }
    private static boolean loaderActive(){
        try {
            webDriver.findElement(getBy(Helpers.getLoaderCss()));
            return true;
        }catch (NoSuchElementException ignored){
            return false;
        }
    }

    public static boolean consentPresented(){
        try {
            webDriver.findElement(getBy(Helpers.getConsentPageCss()));
            return true;

        }catch (NoSuchElementException ignored){
            return false;
        }

    }
    public static boolean userLoggedIn(){
        try {
            webDriver.findElement(getBy(Helpers.getLoggedInCss()));
            return true;

        }catch (NoSuchElementException ignored){
            return false;
        }

    }




    public static void waitElementLoadedBy(By target){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(target));
    }

    public static void waitElementLoaded(String target){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(getIdBy(target)));
    }
    public static void waitElementLoadedEl(WebElement element){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static List<WebElement> getElementArray (String target){
        return webDriver.findElements(getBy(target));
    }


    public static WebElement getCssElement (String target){
        return webDriver.findElement(getBy(target));
    }

    public static WebElement getForCssElement(String path){
        return webDriver.findElement(getBy(Helpers.getForCss(path)));
    }

    public static By getclassCssBy (String target){
        return getBy(Helpers.getClassCss(target));
    }
    public static By getForCssBy (String target){
        return getBy(Helpers.getForCss(target));
    }





    public static WebElement getIdCssElement (String target){
        return webDriver.findElement(getBy(Helpers.getIdCss(target)));
    }
    public static WebElement getIdCssElementContains(String target){
        return webDriver.findElement(getIdContainsBy(target));
    }
    private static By getIdContainsBy(String target){
        return By.cssSelector(Helpers.getIdCssContains(target));

    }
    public static By getIdBy (String target){
        return By.cssSelector(Helpers.getIdCss(target));
    }
    private static By getBy(String target){
        return By.cssSelector(target);
    }

    public static WebElement getClasCssElement (String target){
        return webDriver.findElement(By.cssSelector(Helpers.getClassCss(target)));
    }

    public static WebElement getDialogColumnEl(int number) {
        return ElementHandler.getIdCssElement(Helpers.locatorMap("columnBox"))
                .findElement(getBydialogColumn(number));
    }
    private static By getBydialogColumn(int number){
        return getBy("label:nth-child(" + number + ") > span:nth-child(2)");
    }

    public static WebElement getAdditionalColumnEl(int number) {
        return ElementHandler.getIdCssElement(Helpers.locatorMap("columnBoxAdd"))
                .findElement(getBy("label:nth-child(" + number + ") > span:nth-child(2)"));
    }

    private static WebElement getConsentCssElement (){
        return webDriver.findElement(getBy(Helpers.getConsentPageCss()));
    }



}
