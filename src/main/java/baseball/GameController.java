package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {
    private static final String gameStart = "1";
    private static final String gameEnd = "2";

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        String state = gameStart;
        GameSimulation gameSimulation = new GameSimulation(computer);
        while (state.equals(gameStart)) {
            gameSimulation.init();
            gameSimulation.playGame();
            success();

            state = readLine();
            checkEndOfGame(state);
        }
    }

    private boolean checkEndOfGame(String response) {
        if (response.equals(gameEnd)) {
            return false;
        }
        if (response.equals(gameStart)) {
            return true;
        }
        throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
    }

    private void success() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
    }
}
