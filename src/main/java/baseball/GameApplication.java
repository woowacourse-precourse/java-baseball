package baseball;

import baseball.GameNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameApplication {
    private List<Integer> computer;
    private List<Integer> user;
    private int[] result;

    public GameApplication() {
    }

    public void gameStart() {
        while (true) {
            baseballGame();

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (RestartOrExit()) break;
        }
    }

    private boolean RestartOrExit() {
        String input = Console.readLine();
        if (input.equals("2")) {
            return true;
        }
        return false;
    }

    private void baseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        GameNumber computerNumber = new GameNumber();
        GameNumber userNumber = new GameNumber();
        GameNumber resultNumber = new GameNumber();

        computer = computerNumber.getComputerNumber();

        while (true) {
            user = userNumber.getUserNumber();
            // 결과 저장
            result = resultNumber.getResult(computer, user);

            // 결과 프린트
            System.out.println(resultNumber.printResult(result));

            if (resultNumber.executeApplication(result)) break;
        }
    }
}
