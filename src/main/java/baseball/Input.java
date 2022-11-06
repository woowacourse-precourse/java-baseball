package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private static final char MINIMUM_CHAR = '1';
    private static final char MAXIMUM_CHAR = '9';

    private final int listSize;

    public Input(int listSize) {
        this.listSize = listSize;
    }

    public List<Character> readAndMakeInputList() {
        String inputString = Console.readLine();
        validStringLength(inputString);
        return stringToList(inputString);
    }

    // method for test
    public void printInputString(String inputString) {
        validStringLength(inputString);
        System.out.println(stringToList(inputString));
    }

    private List<Character> stringToList(String inputString) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            list.add(inputString.charAt(i));
        }
        validOnlyOneNumInList(list);
        validNumElementAndNoZero(list);
        return list;
    }

    private void validStringLength(String inputString) {
        if (inputString.length() != listSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validOnlyOneNumInList(List<Character> list) {
        if (list.get(0) == list.get(1) || list.get(1) == list.get(2) || list.get(0) == list.get(
            2)) {
            throw new IllegalArgumentException();
        }
    }

    private void validNumElementAndNoZero(List<Character> list) {
        for (Character character : list) {
            if (character < MINIMUM_CHAR || MAXIMUM_CHAR < character) {
                throw new IllegalArgumentException();
            }
        }
    }
}
