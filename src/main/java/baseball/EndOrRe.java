package baseball;

import camp.nextstep.edu.missionutils.Console;

public class EndOrRe {

    private static final String ONE = "1";
    private static final String TWO = "2";

    public Integer readAndMakeInputList() {
        String inputString = Console.readLine();
        validOneOrTwo(inputString);
        return stringToInt(inputString);
    }

    // method for test
    public void printInputString(String inputString) {
        validOneOrTwo(inputString);
        System.out.println(stringToInt(inputString));
    }

    private Integer stringToInt(String inputString) {
        return Integer.valueOf(inputString);
    }

    private void validOneOrTwo(String inputString) {
        if (!inputString.equals(ONE) && !inputString.equals(TWO)) {
            throw new IllegalArgumentException();
        }
    }
}
