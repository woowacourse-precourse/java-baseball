package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        baseballGame.startGame();
        while (true) {
            List<Integer> computerNumber = baseballGame.createComputerNumber();
            baseballGame.runGame(computerNumber);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();
            if (restart.equals("2")) {
                break;
            }
        }
    }
}
