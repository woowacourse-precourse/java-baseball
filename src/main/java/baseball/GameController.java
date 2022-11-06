package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.logging.ConsoleHandler;

public class GameController {
    private static final Boolean gameStart = true;
    public void start() {
        Computer computer = new Computer();
        Boolean state = gameStart;
        while (state.equals(gameStart)) {
            computer.init();
            GameSimulation gameSimulation = new GameSimulation(computer);
            gameSimulation.playGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

            String response = Console.readLine();
            checkEndOfGame(response);
        }
    }

    private Boolean checkEndOfGame(String response) {
        if (response.equals("1")) {
            return true;
        }
        if (response.equals("2")) {
            return false;
        }
        if (!(response.equals("1") || response.equals("2"))) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }

        return true;
    }
}
