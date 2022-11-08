package baseball.game;

import static baseball.utils.NumberGenerator.createNonDuplicateNumbers;

import baseball.domain.Balls;
import baseball.domain.CompareResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private Balls answer;

    private final GameStatus gameStatus;

    public BaseballGame() {
        this.gameStatus = new GameStatus();
    }

    public void play() {
        setUp();
        process();
        askForNewGame();
    }

    private void setUp() {
        System.out.println(START_GAME_MESSAGE);
        answer = new Balls(createNonDuplicateNumbers());
        gameStatus.initStatus();
    }

    private void process() {
        while (!isGameEnd()) {
            CompareResult result = compareBallNumbers();
            OutputView.displayCompareResult(result);
            gameStatus.setStatus(result);
        }
    }

    private CompareResult compareBallNumbers() {
        Balls player = new Balls(InputView.getBallNumbers());
        return answer.compareTo(player);
    }

    private boolean isGameEnd() {
        return gameStatus.isGameEnd();
    }

    private void askForNewGame() {
        GameOption option = InputView.getGameOption();

        if (option.isRestart()) {
            play();
        }
    }
}