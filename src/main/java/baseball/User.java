package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer> generateNumberList(String numberString) {
        List<Integer> numberList = new ArrayList<>();
        String[] numberStringArray = numberString.split("");

        for(String number : numberStringArray) {
            numberList.add(Integer.parseInt(number));
        }

        return numberList;
    }
}
