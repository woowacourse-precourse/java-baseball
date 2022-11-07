package baseball;


import java.util.ArrayList;
import java.util.List;

public class UserNumbers {
    List<Integer> userNumbers = new ArrayList<>();

    public List<Integer> userNumbers(int userNumber) {

        userNumbers.add(userNumber / 100);
        userNumbers.add((userNumber % 100) / 10);
        userNumbers.add(userNumber % 10);

        return userNumbers;
    }
}
