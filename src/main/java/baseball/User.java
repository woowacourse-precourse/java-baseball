package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String number;
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public void inputNumber() {
        System.out.print(INPUT_NUMBER);
        number = Console.readLine();
    }

    public void GameStart() {
        System.out.println(GAME_START);
    }

    public List<Integer> createUserNumber() {
        inputNumber();
        String[] splitNumber = number.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for (String number : splitNumber) {
            int numberToInt = Integer.parseInt(number);
            inputException(userNumbers, numberToInt);
            userNumbers.add(numberToInt);
        }
        return userNumbers;
    }

    public void inputException(List<Integer> userNumbers, int numberToInt) {
        int userNumbersSize = userNumbers.size();
        if (userNumbers.contains(numberToInt)) {
            throw new IllegalArgumentException();
        }
        if (userNumbersSize != 3) {
            throw new IllegalArgumentException();
        }
        if (!isNumber(userNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNumber(List<Integer> userNumbers) {
        for (int number : userNumbers) {
            if (number < 1 || number > 9) {
                return false;
            }
        }
        return true;
    }

    public void restartGame() {
        Computer computer = new Computer();
        number = Console.readLine();
        int inputNumber = Integer.parseInt(number);
        if (inputNumber == 1) {
            computer.printGameResult();
        }
    }
}
