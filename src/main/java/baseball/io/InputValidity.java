package baseball.io;

import java.util.List;

public class InputValidity {

    private static final char MINIMUM_CHAR = '1';
    private static final char MAXIMUM_CHAR = '9';

    public void validStringLength(String inputString, int listSize) {
        if (inputString.length() != listSize) {
            throw new IllegalArgumentException();
        }
    }

    public void validForList(List<Character> list) {
        validNumElementAndNoZero(list);
        validOnlyOneNumInList(list);
    }

    private void validOnlyOneNumInList(List<Character> list) {
        if (list.size() != list.stream().distinct().count()) {
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
