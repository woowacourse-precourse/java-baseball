package baseball.game;

import baseball.view.ErrorView;
import baseball.view.InputView;
import baseball.view.OutputView;

public final class BaseballGame implements Game {
    InputView inputView;
    OutputView outputView;
    ErrorView errorView;

    public BaseballGame(InputView inputView, OutputView outputView, ErrorView errorView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorView = errorView;
    }

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
            throw new IllegalArgumentException(e);
        }
    }

    private void printInputMessage() {
        outputView.print("숫자를 입력해주세요 : ");
    }

    private void printEndMessage() {
        outputView.print("3개의 숫자를 모두 맞히셨습니다 !게임 종료\n");
    }

    private void printScore(Score score) {
        printBall(score);
        printStrike(score);
        printNothing(score);
        outputView.print("\n");
    }


    private void printBall(Score score) {
        if (score.isOneBall()) {
            outputView.print("1볼 ");
            return;
        }
        if (score.isTwoBall()) {
            outputView.print("2볼 ");
            return;
        }
        if (score.isThreeBall()) {
            outputView.print("3볼 ");
        }
    }

    private void printStrike(Score score) {
        if (score.isOneStrike()) {
            outputView.print("1스트라이크");
            return;
        }
        if (score.isTwoStrike()) {
            outputView.print("2스트라이크");
            return;
        }
        if (score.isThreeStrike()) {
            outputView.print("3스트라이크");
        }
    }

    private void printNothing(Score score) {
        if (score.isZeroScore()) {
            outputView.print("낫싱");
        }
    }
}
