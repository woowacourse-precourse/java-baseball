package baseball;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public static List<Integer> convertNumberToDigit(String number) throws IllegalArgumentException {

        List<Integer> digitList = new ArrayList<>();

        if (number.length() > 3) throw new IllegalArgumentException();

        for (int i = 0; i < number.length(); i++) {

            digitList.add(number.charAt(i) - '0');

        }

        return digitList;

    }

}
