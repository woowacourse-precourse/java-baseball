package baseball.domain;

import static baseball.util.Converter.stringListToIntList;

import java.util.List;

public class User {
    private List<Integer> userInputNumbers;

    public List<Integer> getUserInputNumbers() {
        return userInputNumbers;
    }

    public void selectUserNumber(String userNumber) {
        userInputNumbers = List.copyOf(stringListToIntList(userNumber));
    }

}
