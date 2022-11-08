package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_FOR_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART = "1";

    public Game() {
    }

    public void start() {
        printGameStartMessage();
        Round round;
        do {
            round = new Round();
            round.start();
        } while (askRestart());
    }

    public void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public boolean askRestart() {
        String playerInput = getPlayerInput(ASK_FOR_GAME_RESTART_MESSAGE);
        return playerInput.equals(RESTART);
    }

    public String getPlayerInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
