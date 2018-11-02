package cz.sazka.tests.LotteryUtils;

import org.junit.Assert;

class DrawInfo {

    /**
     * @return value for particular day or part of day according keyword.
     * @param keyword desired day or part of day.
     */
  private static int getdrawNum(String keyword) {
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

    /**
     * Split draw string to particular days or part of day, saves to array and pick that many values as many days/part of day.
     * @param draws string definiton of drawdate/drawhour.
     * @return values for each desired day or part of day.
     */
     static int[] getAllDrawNums(String draws) {
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
