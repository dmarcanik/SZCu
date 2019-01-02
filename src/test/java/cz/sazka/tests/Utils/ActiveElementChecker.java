package cz.sazka.tests.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.w3c.dom.Attr;

import javax.smartcardio.ATR;

public class ActiveElementChecker {


    public static boolean isActive(By by){
        boolean result;
        try {
            result =  ElementHandler.getElement(by).isDisplayed();

        }catch (NoSuchElementException ignored){
            result = false;
        }
        return result;

    }


}
