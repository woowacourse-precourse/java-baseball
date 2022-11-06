package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.NUMBERS_LENGTH;

public class Convert {

    public List<Integer> IntegerList(String input) {
        List<String> stringList = StringToList(input);
        return StringListToIntegerList(stringList);
    }

    private List<String> StringToList(String input) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            stringList.add(String.valueOf(input.charAt(i)));
        }
        return stringList;
    }

    private List<Integer> StringListToIntegerList(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            integerList.add(Integer.parseInt(stringList.get(i)));
        }
        return integerList;
    }
}
