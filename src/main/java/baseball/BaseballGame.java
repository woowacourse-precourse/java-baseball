package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BaseballGame {

    private Computer computer;
    private User user;
    private GameResult result;

    BaseballGame() {
        computer = new Computer();
        user = new User();
        result = new GameResult();
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.pickRandomNumbersFrom1To9();
        result.init();

        while (!result.isThreeStrike()) {
            try {
                List<Integer> userNumbers = user.pickNumbers();
                result.compare(computer.getNumbers(), userNumbers);
                printResult();

            } catch (IllegalArgumentException exception) {
                throw exception;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        switch (Console.readLine()) {
            case "1":
                return true;
            case "2":
                return false;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void printResult() {
        System.out.println(result.toString());
    }
}
