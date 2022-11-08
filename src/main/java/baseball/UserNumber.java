package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserNumber {
    private List<Integer> userNumber;
    private UserNumberException userNumberException;

    public UserNumber() {
        userNumber = new ArrayList<>();
        userNumberException = new UserNumberException();
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void makeUserNumber() {
        System.out.println(SystemMessage.GAME_START_MESSAGE);
        List<Integer> inputNumbers = new ArrayList<>();
        String inputNumber = Console.readLine();
        userNumberException.checkException(inputNumber);

        for (int i = 0; i < SystemMessage.NUMBER_SIZE; i++) {
            int number = inputNumber.charAt(i) - '0';
            inputNumbers.add(number);
        }
        userNumber = new ArrayList<>(inputNumbers);
    }
}