package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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

        Validity valid = new Validity();
        valid.isNumberValid(inputNumber);

        return Revert.revertStringToList(inputNumber);
    }
}
