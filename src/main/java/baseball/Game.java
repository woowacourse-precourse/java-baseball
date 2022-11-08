package baseball;

import baseball.model.Balls;
import baseball.model.GameStatus;
import baseball.model.Result;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.Input;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int GAME_RESTART_STATUS = 1;
    private static final int MAX_BALLS_SIZE = 3;
    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_BALL_NUMBER = 9;

    private final Computer computer;
    private final Player player;

    public Game(Computer computer, Player player) {
        Output.println(START_GAME_MESSAGE);
        this.computer = computer;
        this.player = player;
    }

    public void startGame() {
        Balls computerBalls = computer.generateRandomBalls(MAX_BALLS_SIZE, MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        GameStatus gameStatus = new GameStatus(GAME_RESTART_STATUS);

        while (true) {
            Output.print(INPUT_NUMBER_MESSAGE);
            Balls playerBalls = player.generatePlayerBalls(Input.inputValue());
            Result result = computerBalls.generateResult(playerBalls);
            Output.printResult(result);

            if (result.isGameOver()) {
                gameStatus.changeStatus(Console.readLine());
                break;
            }
        }
        if (gameStatus.isRestart()) {
            startGame();
        }
    }
}
