package cz.sazka.tests.Utils;

import cz.sazka.tests.Steps.Hook;
import gherkin.lexer.No;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ElementHandler {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    public static void clickCmd(WebElement element) {

        webDriverWait().until((ExpectedConditions.elementToBeClickable(element)));
        waitPageToBeLoaded();
        element.click();
        waitPageToBeLoaded();
    }

    public static void clickOn(By by) {
        try {
            waitForPageTobeLoaded();
            waitUntilObstaclesAreGone();
            webDriverWait().until(ExpectedConditions.elementToBeClickable(by));
            WebElement element = getElement(by);
            element.click();
        }catch (TimeoutException | NoSuchElementException e){
            log.error(e);
        }

    }


    public static WebDriverWait webDriverWait() {
        return new WebDriverWait(webDriver, 30);
    }


    public static void waitUntilObstaclesAreGone() {
        List<String> tagSelectors = Helpers.getObstacles();
        List<ExpectedCondition<Boolean>> expected = tagSelectors.stream().map(selector -> ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selector))).collect(Collectors.toList());
        ExpectedCondition[] expectedConditions = expected.toArray(new ExpectedCondition[expected.size()]);
        webDriverWait().until(ExpectedConditions.or(expectedConditions));
    }


    public static void waitPageToBeLoaded() {
        List<String> tagSelectors = Helpers.GetLoadingCsss();
        List<ExpectedCondition<WebElement>> expected = tagSelectors.stream().map(selector -> ExpectedConditions.elementToBeClickable(By.cssSelector(selector))).collect(Collectors.toList());
        ExpectedCondition[] expectedConditions = expected.toArray(new ExpectedCondition[expected.size()]);
        webDriverWait().until(ExpectedConditions.or(expectedConditions));
        By loader = ElementHandler.getBy(Helpers.getLoaderCss());
        if (ActiveElementChecker.isActive(loader)) {
            waitLoadingComplete();
        }
        waitTobeLoaded();
    }

    private static void waitForPageTobeLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> {
            if (driver == null) {
                return false;
            }
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 20);
        try {
            wait.until(input -> expectation.apply(webDriver));
        } catch (TimeoutException e) {
            throw new TimeoutException("Page is not loaded after " + 20 + " seconds.");
        }

    }

    private static void waitTobeLoaded() {
        webDriverWait().until(ExpectedConditions.presenceOfElementLocated(getIdBy(Helpers.locatorMap("loadingScreen"))));
    }

    public static void waitToBeLoggedIn() {
        webDriverWait().until(ExpectedConditions.presenceOfElementLocated(getBy(Helpers.getLoggedInCss())));
    }

    public static void waitToBeLoggedOut() {
        webDriverWait().until(ExpectedConditions.elementToBeClickable((getBy(Helpers.getLoggedOutCss()))));
        webDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(getBy(Helpers.getClassCss("mwc-modal-backdrop mwc-fade mwc-in"))));

        waitPageToBeLoaded();
    }

    private static void waitLoadingComplete() {
        webDriverWait().until(ExpectedConditions.not(ExpectedConditions.attributeContains(webDriver.findElement(By.tagName("div")), "class", "loading")));
    }

    public static void acceptConsent() {
        WebElement element = ElementHandler.getConsentCssElement();
        if (element.isDisplayed()) {
            clickOn(getBy(Helpers.getClassCssContains("agree")));

        }
    }


    public static void waitElementLoadedBy(By target) {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(target));
    }

    public static void waitElementLoaded(String target) {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(getIdBy(target)));
    }

    public static void waitElementLoadedEl(WebElement element) {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static List<WebElement> getElementArray(String target) {
        return webDriver.findElements(getBy(target));
    }

    public static List<WebElement> getElementArrayBy(By target) {
        return webDriver.findElements(target);
    }


    public static WebElement getCssElement(String target) {
        return webDriver.findElement(getBy(target));
    }

    public static WebElement getForCssElement(String path) {
        return webDriver.findElement(getBy(Helpers.getForCss(path)));
    }

    public static By getclassCssBy(String target) {
        return getBy(Helpers.getClassCss(target));
    }

    public static By getForCssBy(String target) {
        return getBy(Helpers.getForCss(target));
    }

    public static WebElement getElement(By by) {
        return webDriver.findElement(by);
    }


    public static WebElement getIdCssElement(String target) {
        return webDriver.findElement(getBy(Helpers.getIdCss(target)));
    }

    public static WebElement getIdCssElementContains(String target) {
        return webDriver.findElement(getIdContainsBy(target));
    }

    public static By getIdContainsBy(String target) {
        return By.cssSelector(Helpers.getIdCssContains(target));

    }

    public static By getIdBy(String target) {
        return By.cssSelector(Helpers.getIdCss(target));
    }

    public static By getBy(String target) {
        return By.cssSelector(target);
    }

    public static WebElement getClasCssElement(String target) {
        return webDriver.findElement(By.cssSelector(Helpers.getClassCss(target)));
    }

    public static By getColumnNumber(String target) {
        return getBy(Helpers.getNumberCSS(target));
    }

    public static By getAddColumnNumber(String target) {
        return getBy(Helpers.getAddNumberCSS(target));
    }

    public static By getKenoNumberCount(String gameField, String value) {
        return getBy(Helpers.getMergedCssAnd(Helpers.getDataColumn(String.valueOf(gameField))+">[class*=\"wager-count\"]>label>",Helpers.getNumberCountCSS(value)));
    }
    public static By getKenoNumbers(String gameField, String value) {
        return getBy(Helpers.getMergedCssAnd(Helpers.getDataColumn(String.valueOf(gameField))+">[class*=\"keno-ticket\"]>label>",Helpers.getNumberCountCSS(value)));
    }
    public static By getKenoDeposit(String gameField, String value) {
        return getBy(Helpers.getMergedCssAnd(Helpers.getDataColumn(String.valueOf(gameField))+">[class*=\"keno-bet-amount\"]>label>",Helpers.getNumberCountCSS(value)));
    }

    private static WebElement getConsentCssElement() {
        return webDriver.findElement(getBy(Helpers.getConsentPageCss()));
    }


}
