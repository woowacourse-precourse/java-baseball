package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static ThreeNumber computerNumber;
    private static ThreeNumber userNumber;

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
        String user = Console.readLine();
        selectPlayerNumberException(user);
        int number1 = user.charAt(0) - '0';
        int number2 = user.charAt(1) - '0';
        int number3 = user.charAt(2) - '0';
        userNumber = new ThreeNumber(number1, number2, number3);
        determineAnswer();
    }

    private static void selectPlayerNumberException(String user) {

    }

    private static void determineAnswer() {

    }

}
