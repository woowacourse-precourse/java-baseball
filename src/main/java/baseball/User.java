package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    public int inputNumber() {
        int number = Integer.parseInt(Console.readLine());
        return number;
    }

    public List<Integer> createUserNumber() {
       List<Integer> userNumbers = new ArrayList<>();
       while (userNumbers.size() < 3) {
           userNumbers.add(inputNumber());
       }
       return userNumbers;
    }
}
