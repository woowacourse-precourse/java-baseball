package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private final String userNumbers;
    private final List<Integer> userNumbersList;

    public User() {
        this.userNumbers = setUserInput();
        this.userNumbersList = setUserNumberList(this.userNumbers);
    }
    public List<Integer> getUserNumbers() {
        return userNumbersList;
    }

    private String setUserInput() {
        String userInput = Console.readLine();
        System.out.println(userInput);
        return userInput;
    }

    private List<Integer> setUserNumberList(String inputNumber) {

        char[] charArray = Revert.revertStringToCharArray(inputNumber);
        int[] intArray = Revert.revertCharArrToIntArr(charArray);

        Validity.isInputNumberValid(charArray);
        return Revert.revertIntArrayToList(intArray);
    }
}
