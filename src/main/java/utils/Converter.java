package utils;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<Integer> convertStringToIntegerList(String str) {
        List<Integer> integerList = new ArrayList<>();

        for (int index = 0; index < str.length(); index++) {
            int intValue = str.charAt(index) - '0';
            integerList.add(intValue);
        }
        return integerList;
    }
}
