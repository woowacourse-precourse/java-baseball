package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserNumber {
    UserNumberException userNumberException = new UserNumberException();

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
        System.out.println(INPUT_NUMBER);
        List<Integer> inputNumbers = new ArrayList<>();
        String inputNumber = Console.readLine();
        userNumberException.checkUserNumberException(inputNumber);
        for (int i = 0; i < inputNumber.length(); i++) {
            int number = inputNumber.charAt(i) - '0';
            inputNumbers.add(number);
        }
        userNumber = new ArrayList<>(inputNumbers);
    }
}