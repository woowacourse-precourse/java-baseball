package baseball.input.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {

    public static List<Integer> getDigitNumberList(String number) {
        List<Integer> numberDigitList = new ArrayList<>();
        for (String numberDigit : number.split("")) {
            numberDigitList.add(Integer.valueOf(numberDigit));
        }
        return numberDigitList;
    }

}
