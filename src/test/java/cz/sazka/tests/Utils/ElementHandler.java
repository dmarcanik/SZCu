package cz.sazka.tests.Utils;

import cz.sazka.tests.Steps.Hook;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.InvalidParameterException;
import java.util.List;

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
        new  WebDriverWait(webDriver,10)
                .until((ExpectedConditions.elementToBeClickable(element)));
        element.click();
        waitPageToBeLoaded("authenticated");


    }

    public static void waitPageToBeLoaded(String value){
        new WebDriverWait(webDriver,10)
                .until((ExpectedConditions.attributeContains(webDriver.findElement(By.tagName("body")),"class",value)));

    }

    public static void waitUntilLoggedIn(){
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(webDriver.findElement(By.tagName("body")),"class","unauthenticated")));
        wait.until(ExpectedConditions.attributeContains(webDriver.findElement(By.tagName("body")),"class","authenticated"));

    }




    public static void waitElementLoaded(String target){
        new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.elementToBeClickable(getidXElement(target)));
    }
    public static void waitElementLoadedEl(WebElement element){
        new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public static List<WebElement> getElementArray (String target){
        return webDriver.findElements(By.xpath(target));
    }


    public static WebElement getidXElement (String target){
        return webDriver.findElement(By.xpath(Helpers.getIdPath(target)));
    }

    public static WebElement getClassXElement (String target){
        return webDriver.findElement(By.xpath(Helpers.getClassPath(target)));
    }
    public static WebElement getIdCssElement (String target){
        return webDriver.findElement(By.cssSelector(Helpers.getIdCss(target)));
    }
    public static WebElement getClasCssElement (String target){
        return webDriver.findElement(By.cssSelector(Helpers.getClassCss(target)));
    }
    public static WebElement getDialogColumnEl(int number) {
        return ElementHandler.getidXElement("dialog-column-checkboxes")
                .findElement(By.cssSelector("label:nth-child(" + number + ") > span:nth-child(2)"));
    }

    public static WebElement getAdditionalColumnEl(int number) {
        return ElementHandler.getidXElement("dialog-column-checkboxes-additional")
                .findElement(By.cssSelector("label:nth-child(" + number + ") > span:nth-child(2)"));
    }





    public static WebElement getConsentElement (){
        return webDriver.findElement(By.xpath(Helpers.getConsentPagePath()));
    }






    public static WebElement getCorrectElement(List<String> xpaths){
        WebElement correctElement = null;
        for (String item:xpaths) {
            boolean isActive = webDriver.findElements(By.xpath(item)).size()>0;

            if (isActive){
                correctElement= webDriver.findElement(By.xpath(item));
                break;
            }
        }
        return correctElement;
    }


    public static WebElement getPropnameElement(String target) {
        return webDriver.findElement(By.xpath(Helpers.getPropnamePath(target)));
    }

    public static WebElement getCmdIdElement(String target) {
        return webDriver.findElement(By.xpath(Helpers.getCmdIdPath(target)));
    }
    public static void waitAjaxComplete() {
        FluentWait<WebDriver> fluentWait = new WebDriverWait(webDriver, 10);
        fluentWait.until(ExpectedConditions.not(
                ExpectedConditions.attributeContains(By.tagName("Body"), "class", "ajax")));
        fluentWait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.xpath("//*[@id=\"wsfDisableUiOverlay\"]"),"class","load")));
    }
    public static void waitLoadingComplete (WebElement element){
        new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.not(ExpectedConditions.attributeContains(element.findElement(By.tagName("div")),"class","loading")));
    }
}
