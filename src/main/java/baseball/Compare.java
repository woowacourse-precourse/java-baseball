package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;

public class Compare {
    String input;
    List<Integer> computerNumber;

    Compare(String input) {
        this.input = input;
    }

    List<String> StringInputToList(String input) {
        List<String> stringList = new ArrayList<>();
        for (int i=0; i<PLAYING_NUMBERS_LENGTH; i++) {
            stringList.add(String.valueOf(input.charAt(i)));
        }
        return stringList;
    }

    List<Integer> StringListToInteger(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();
        for (int i=0; i<PLAYING_NUMBERS_LENGTH; i++) {
            integerList.add(Integer.parseInt(stringList.get(i)));
        }
        return integerList;
    }
}
