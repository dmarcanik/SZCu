package cz.sazka.tests.LotteryUtils;

import org.junit.Assert;

public class DrawInfo {


    public static int getdrawNum(String keyword) {
        int num = 7;
        switch (keyword) {
            case "pondeli":
                num = 1;
                break;
            case "utery":
                num = 2;
                break;
            case "streda":
                num = 3;
                break;
            case "ctvrtek":
                num = 4;
                break;
            case "patek":
                num = 5;
                break;
            case "sobota":
                num = 6;
                break;
            case "nedele":
                num = 0;
                break;
            case "poledne":
                num = 12;
                break;
            case "vecer":
                num = 20;
                break;
        }
        Assert.assertNotEquals(7,num);
        return num;
    }

    public static int[] getAllDrawNums(String draws) {
        String drawnames[] = draws.split(",");
        int[] drawNumbers = new int[drawnames.length];
        int i = 0;
        for (String drawname : drawnames) {
            drawNumbers[i] = getdrawNum(drawname);
            i++;

        }
        return drawNumbers;
    }
}
