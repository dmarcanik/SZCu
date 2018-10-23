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

    public static List<WebElement> findCmds(String target) {
        FluentWait<WebDriver> fluentWait = new WebDriverWait(webDriver, 10);
        fluentWait.until(presenceOfElementLocated(By.xpath(Helpers.getIdPath(target))));

        List<WebElement> elements = webDriver.findElements(By.xpath(Helpers.getIdPath(target)));

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
        return new WebDriverWait(webDriver,20);
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

    public static void waitTobeLoaded(){
        webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helpers.getIdPath(Helpers.locatorMap("loadingScreen")))));
    }
    public static void waitToBeLoggedIn(){
        webDriverWait().until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(Helpers.getLoggedInCss()))));
    }
    public static void waitToBeLoggedOut(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable((By.cssSelector(Helpers.getLoggedOutCss()))));
        webDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Helpers.getClassPath("mwc-modal-backdrop mwc-fade mwc-in"))));

        waitPageToBeLoaded();
    }
    private static void waitLoadingComplete (){
        webDriverWait().until(ExpectedConditions.not(ExpectedConditions.attributeContains(webDriver.findElement(By.tagName("div")),"class","loading")));
    }

    public static void acceptConsent (){
        WebElement element = ElementHandler.getConsentElement();
        if (element.isDisplayed()){
            element.findElement(By.cssSelector("[class=agree]")).click();

        }
    }


    public static boolean isLoggoutActive(){
        try {
            ElementHandler.getClassXElement(Helpers.locatorMap("logout"));
            return true;

        }catch (NoSuchElementException ignored){
            return false;
        }
    }
    private static boolean loaderActive(){
        try {
            webDriver.findElement(By.cssSelector(Helpers.getLoaderCss()));
            return true;
        }catch (NoSuchElementException ignored){
            return false;
        }
    }

    public static boolean consentPresented(){
        try {
            webDriver.findElement(By.xpath(Helpers.getConsentPagePath()));
            return true;

        }catch (NoSuchElementException ignored){
            return false;
        }

    }
    public static boolean userLoggedIn(){
        try {
            webDriver.findElement(By.cssSelector(Helpers.getLoggedInCss()));
            return true;

        }catch (NoSuchElementException ignored){
            return false;
        }

    }




    public static void waitElementLoadedBy(By target){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(target));
    }

    public static void waitElementLoaded(String target){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(getIdXpathBy(target)));
    }
    public static void waitElementLoadedEl(WebElement element){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static List<WebElement> getElementArray (String target){
        return webDriver.findElements(By.xpath(target));
    }

    public static WebElement getXpathElement (String target){
        return webDriver.findElement(By.xpath(target));
    }



    public static WebElement getidXElement (String target){
        return webDriver.findElement(By.xpath(Helpers.getIdPath(target)));
    }
    public static By getIdXpathBy (String target){
        return By.xpath(Helpers.getIdPath(target));
    }

    public static WebElement getClassXElement (String target){
        return webDriver.findElement(By.xpath(Helpers.getClassPath(target)));
    }
    public static WebElement getForCssElement(String path){
        return webDriver.findElement(By.cssSelector(Helpers.getForCss(path)));
    }
    public static By getclassBy (String target){
        return By.xpath(Helpers.getClassPath(target));
    }
    public static By getclassCssBy (String target){
        return By.xpath(Helpers.getClassCss(target));
    }
    public static By getForCssBy (String target){
        return By.cssSelector(Helpers.getForCss(target));
    }



    public static WebElement getIdCssElement (String target){
        return webDriver.findElement(By.cssSelector(Helpers.getIdCss(target)));
    }
    public static WebElement getClasCssElement (String target){
        return webDriver.findElement(By.cssSelector(Helpers.getClassCss(target)));
    }

    public static WebElement getDialogColumnEl(int number) {
        return ElementHandler.getidXElement(Helpers.locatorMap("columnBox"))
                .findElement(By.cssSelector("label:nth-child(" + number + ") > span:nth-child(2)"));
    }

    public static WebElement getAdditionalColumnEl(int number) {
        return ElementHandler.getidXElement(Helpers.locatorMap("columnBoxAdd"))
                .findElement(By.cssSelector("label:nth-child(" + number + ") > span:nth-child(2)"));
    }


    public static WebElement getConsentElement (){
        return webDriver.findElement(By.xpath(Helpers.getConsentPagePath()));
    }



}
