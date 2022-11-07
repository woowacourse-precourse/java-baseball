package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static ThreeNumber computerNumber;
    private static ThreeNumber playerNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        selectComputerNumber();
    }

    private static void selectComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        computerNumber = new ThreeNumber(computer.get(0), computer.get(1), computer.get(2));
        selectPlayerNumber();
    }

    private static void selectPlayerNumber() {
        String playerInput = Console.readLine();
        selectPlayerNumberException(playerInput);
        int number1 = playerInput.charAt(0) - '0';
        int number2 = playerInput.charAt(1) - '0';
        int number3 = playerInput.charAt(2) - '0';
        playerNumber = new ThreeNumber(number1, number2, number3);
        determineAnswer();
    }

    private static void selectPlayerNumberException(String playerInput) {
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        List<Character> numbers = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        for (int i = 0; i < playerInput.length(); i++) {
            if (!numbers.contains(playerInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        List<Character> duplicateCheckList = new ArrayList<>();
        for (int i = 0; i < playerInput.length(); i++) {
            char playerNumber = playerInput.charAt(i);
            if (duplicateCheckList.contains(playerNumber)) {
                throw new IllegalArgumentException();
            }
            duplicateCheckList.add(playerNumber);
        }
    }

    private static void determineAnswer() {

    }

}
