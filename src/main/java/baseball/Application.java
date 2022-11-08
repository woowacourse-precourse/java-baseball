package baseball;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        String controlText = MessageUtils.START_TEXT;
        OutputView.printStartMessage();
        while (!controlText.equals(MessageUtils.FINISH_TEXT)) {
            playBaseballGame();
            finishBaseballGame();
            controlText = InputView.inputPlayNumber();
        }
    }

    private static void finishBaseballGame() {
        OutputView.printFinishMessage();
    }

    private static void playBaseballGame() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startPlay();
        while (baseballGame.getSwingResult().get(Swing.STRIKE) != MessageUtils.STRIKE_COUNT) {
            Map<Swing, Integer> swingResult = baseballGame.playBaseball(new PlayerNumber(StringParsingUtils.parseToBallNumber(InputView.inputBallNumber())));
            OutputView.printSwingResult(swingResult);
        }
    }
}
