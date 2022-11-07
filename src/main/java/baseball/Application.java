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
        System.out.println("computer: " + computer.get(0));
        System.out.println("computer: " + computer.get(1));
        System.out.println("computer: " + computer.get(2));
        selectPlayerNumber();
    }

    private static void selectPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();
        selectPlayerNumberException(playerInput);
        int number1 = playerInput.charAt(0) - '0';
        int number2 = playerInput.charAt(1) - '0';
        int number3 = playerInput.charAt(2) - '0';
        playerNumber = new ThreeNumber(number1, number2, number3);
        provideHint();
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

    private static void provideHint() {
        int strike = countStrike();
        int ball = countBall();
        String hintMessage = makeHintMessage(strike, ball);
        System.out.println(hintMessage);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            endGame();
            return;
        }
        selectPlayerNumber();
    }

    private static int countStrike() {
        int count = 0;
        if (computerNumber.number1 == playerNumber.number1) {
            count += 1;
        }
        if (computerNumber.number2 == playerNumber.number2) {
            count += 1;
        }
        if (computerNumber.number3 == playerNumber.number3) {
            count += 1;
        }
        return count;
    }

    private static int countBall() {
        int count = 0;
        if ((computerNumber.number1 == playerNumber.number2) || (computerNumber.number1 == playerNumber.number3)) {
            count += 1;
        }
        if ((computerNumber.number2 == playerNumber.number1) || (computerNumber.number2 == playerNumber.number3)) {
            count += 1;
        }
        if ((computerNumber.number3 == playerNumber.number1) || (computerNumber.number3 == playerNumber.number2)) {
            count += 1;
        }
        return count;
    }

    private static String makeHintMessage(int strike, int ball) {
        String hintMessage = "";
        if (ball > 0) {
            hintMessage += ball + "볼";
        }
        if (strike > 0) {
            if (ball > 0) {
                hintMessage += " ";
            }
            hintMessage += strike + "스트라이크";
        }
        if ((strike == 0) && (ball == 0)) {
            hintMessage = "낫싱";
        }
        return hintMessage;
    }

    private static void endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();
        endGameException(playerInput);
        int response = Integer.parseInt(playerInput);
        if (response == 1) {
            selectComputerNumber();
        }
        else if (response == 2) {
            return;
        }
    }

    private static void endGameException(String playerInput) {
        if ((!playerInput.equals("1")) && (!playerInput.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

}
