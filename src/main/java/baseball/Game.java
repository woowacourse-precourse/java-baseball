package baseball;

import java.util.List;

public class Game {

    public static final int NUMBER_SIZE = 3;
    public static final String GAME_RESTART = "1";
    public static final String GAME_TERMINATE = "2";
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_TERMINATE_MESSAGE = "게임을 종료합니다.";
    public static final String GAME_CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void startGame() {
        System.out.println(GAME_START_MESSAGE);
        List<Integer> randomNumber = RandomNumber.generateRandomNumberBySize();
        System.out.println(randomNumber); // DEBUG
        boolean isFinish = false;
        while (!isFinish) {
            List<Integer> playerNumber = PlayerInput.inputPlayerNumber();
            isFinish = GameController.calculateHint(randomNumber, playerNumber);
        }
        System.out.println(GAME_CORRECT_MESSAGE);
        restartGame();
    }

    private static void restartGame() {
        System.out.println(GAME_RESTART_MESSAGE);
        String gameProgress = PlayerInput.inputRestartGame();
        if (gameProgress.equals(GAME_RESTART)) {
            startGame();
        } else if (gameProgress.equals(GAME_TERMINATE_MESSAGE)) {
            terminateGame();
        }
    }

    private static void terminateGame() {
        System.out.println(GAME_TERMINATE_MESSAGE);
    }
}

