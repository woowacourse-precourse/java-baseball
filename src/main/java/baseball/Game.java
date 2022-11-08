package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void startGame() {
        Computer computer = new Computer();
        User user = new User();

        List<Integer> computerNumber = computer.makeComputerRandomNumber();
        List<Integer> inputNumber = user.getUserInput();

        Judge.checkTheResult(inputNumber, computerNumber);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        user.getUserInputRestartOrExit();
    }
}
