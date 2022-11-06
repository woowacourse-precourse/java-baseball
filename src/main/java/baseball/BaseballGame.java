package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.ComputerNumber.createComputerNumber;
import static baseball.UserNumber.checkInputUserNumber;

public class BaseballGame {

    private static List<Integer> computerNumbers;
    private static List<Integer> userNumbers;

    public static void playBaseballGame(){
        computerNumbers = createComputerNumber();
        while (true) {
            userNumbers = checkInputUserNumber();
        }
    }

    public static void restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartNumber = Console.readLine();

        if (restartNumber == "1") {
            playBaseballGame();
        }
    }

}
