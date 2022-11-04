package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class UserNumber {

    static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    static final int BALL_SIZE = 3;

    private List<Integer> userNumber;

    public UserNumber() {
        userNumber = new ArrayList<>();
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void makeUserNumber() {
        System.out.println("INPUT_NUMBER = " + INPUT_NUMBER);
        Set<Integer> inputNumbers = new LinkedHashSet<>();
        String inputNumber = Console.readLine();
        for (int i = 0; i < inputNumber.length(); i++) {
            int number = inputNumber.charAt(i) - '0';
            inputNumbers.add(number);
        }
        userNumber = new ArrayList<>(inputNumbers);
    }
}