package baseball.domain;

import baseball.util.Converter;
import java.util.List;

public class User {
    private List<Integer> userInputNumbers;

    public List<Integer> getUserInputNumbers() {
        return userInputNumbers;
    }

    public void selectUserNumber(String userNumber) {
        userInputNumbers = List.copyOf(Converter.stringListToIntList(userNumber));
    }

}
