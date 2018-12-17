package cz.sazka.tests.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.w3c.dom.Attr;

import javax.smartcardio.ATR;

public class ActiveElementChecker {


    public static void waitUntillIsnotActive(){
        boolean obstacle;



    }

    public static boolean isActive(By by){

        try {
            ElementHandler.getElement(by);
            return true;
        }catch (NoSuchElementException ignored){
            return false;
        }



    }


}
