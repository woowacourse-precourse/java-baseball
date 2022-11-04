package baseball;

import java.util.List;

public class BaseballGame {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ERROR_MESSAGE = "잘못된 입력입니다. 게임을 종료합니다.";
    private boolean onGame;
    public BaseballGame() {
        onGame = true;
    }

    public void startGame() {
        System.out.println(GAME_START_MESSAGE);

        Computer computer = new Computer();
        User user = new User();

        while (onGame) {
            try {
                user.receiveThreeNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE);
                onGame = false;
                continue;
            }

            List<Integer> userNumber = user.getThreeNumber();
        }
    }
}
