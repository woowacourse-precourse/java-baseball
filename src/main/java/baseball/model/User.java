package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.Validator.validInput;

public class User {

    private static List<Integer> numbers;

    public User() {
        numbers = receiveInput();
    }

    public static List<Integer> receiveInput() throws IllegalArgumentException {
        List<Integer> user = new ArrayList<>();
        String number = Console.readLine();
        validInput(number);
        for (String digitNumber : number.split("")) {
            user.add(Integer.parseInt(digitNumber));
        }
        return user;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
