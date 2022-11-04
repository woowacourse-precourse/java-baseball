package baseball;

import java.util.List;

public class BaseballGame {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private boolean onGame;
    public BaseballGame() {
        onGame = true;
    }

    public void startGame() {
        System.out.println(GAME_START_MESSAGE);

        Computer computer = new Computer();
        User user = new User();

        while (onGame) {
            user.receiveThreeNumber();

            List<Integer> userNumbers = user.getInputNumber();
            onGame = !computer.isCorrectAnswer(userNumbers);
            user.resetUserNumber();
        }
    }
}
