package baseball.game;

import baseball.view.ErrorView;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.config.GameConstants.GAME_END_MESSAGE;
import static baseball.config.GameConstants.INPUT_ERROR;
import static baseball.config.GameConstants.INPUT_MESSAGE;
import static baseball.config.GameConstants.NOTHING;
import static baseball.config.GameConstants.ONE_BALL;
import static baseball.config.GameConstants.ONE_STRIKE;
import static baseball.config.GameConstants.THREE_BALL;
import static baseball.config.GameConstants.THREE_STRIKE;
import static baseball.config.GameConstants.TWO_BALL;
import static baseball.config.GameConstants.TWO_STRIKE;

/**
 * 컨트롤러에서 동작할 수 있는 게임입니다
 */
public final class BaseballGame implements Game {
    public static final String LINE_FEED = "\n";
    private final InputView inputView;
    private final OutputView outputView;
    private final ErrorView errorView;

    /**
     * Controller와 똑같이 view들을 받아서 생성합니다
     *
     * @param inputView  사용자의 입력을 받게 되는 객체입니다
     * @param outputView 결과를 출력하게 되는 객체입니다
     * @param errorView  에러 발생시 출력하게 될 객체입니다
     */
    public BaseballGame(InputView inputView, OutputView outputView, ErrorView errorView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorView = errorView;
    }

    /**
     * 메서드를 실행 시키면 3스트라이크가 나올 때까지 숫자 야구 게임을 진행합니다
     */
    @Override
    public void play() {
        Score score = Score.ZERO();
        RandomDigits computerAnswer = RandomDigits.createRandom();

        while (!score.isThreeStrike()) {
            PlayerInput playerChoice = getPlayerInput();
            score = Score.calculate(playerChoice, computerAnswer);
            printScore(score);
        }
        printEndMessage();
    }


    private PlayerInput getPlayerInput() {
        try {
            printInputMessage();
            String inputLine = inputView.readLine();
            int playerValue = Integer.parseInt(inputLine);
            return PlayerInput.from(playerValue);
        } catch (IllegalArgumentException e) {
            errorView.printError(e.getMessage());
            throw new IllegalArgumentException(INPUT_ERROR, e);
        }
    }

    private void printInputMessage() {
        outputView.print(INPUT_MESSAGE);
    }

    private void printEndMessage() {
        outputView.print(GAME_END_MESSAGE);
    }

    private void printScore(Score score) {
        printBall(score);
        printStrike(score);
        printNothing(score);
        outputView.print(LINE_FEED);
    }


    private void printBall(Score score) {
        if (score.isOneBall()) {
            outputView.print(ONE_BALL);
            return;
        }
        if (score.isTwoBall()) {
            outputView.print(TWO_BALL);
            return;
        }
        if (score.isThreeBall()) {
            outputView.print(THREE_BALL);
        }
    }

    private void printStrike(Score score) {
        if (score.isOneStrike()) {
            outputView.print(ONE_STRIKE);
            return;
        }
        if (score.isTwoStrike()) {
            outputView.print(TWO_STRIKE);
            return;
        }
        if (score.isThreeStrike()) {
            outputView.print(THREE_STRIKE);
        }
    }

    private void printNothing(Score score) {
        if (score.isZeroScore()) {
            outputView.print(NOTHING);
        }
    }
}
