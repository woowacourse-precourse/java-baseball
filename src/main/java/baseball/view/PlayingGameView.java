package baseball.view;

public class PlayingGameView extends GameView {
    private static final String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String OUTPUT_BALL = "볼 ";
    private static final String OUTPUT_STRIKE = "스트라이크";
    private static final String OUTPUT_NOTHING = "낫싱";
    private static final int ZERO = 0;
    public void enterNumberPrint() {
        print(OUTPUT_ENTER_NUMBER);
    }

    public void gameResultPrint(int strike, int ball) {
        StringBuilder output = new StringBuilder();
        if (ball > ZERO) {
            outputBuilder(output, ball, OUTPUT_BALL);
        }
        if (strike > ZERO) {
            outputBuilder(output, strike, OUTPUT_STRIKE);
        }
        if (strike == ZERO && ball == ZERO) {
            outputBuilder(output, OUTPUT_NOTHING);
        }
        newLine(output);
        print(output.toString());
    }

    public void outputBuilder(StringBuilder output, int judgmentCount, String judgmentString) {
        output.append(judgmentCount).append(judgmentString);
    }

    public void outputBuilder(StringBuilder output, String judgmentString) {
        output.append(judgmentString);
    }
}
