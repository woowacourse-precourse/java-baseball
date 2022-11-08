package baseball.view;

public class PlayingGameView extends GameView {
    private static final String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String OUTPUT_BALL = "볼 ";
    private static final String OUTPUT_STRIKE = "스트라이크";
    private static final String OUTPUT_NOTHING = "낫싱";
    private static final int ZERO = 0;
    public void enterNumberPrint() {
        output = new StringBuilder();
        output.append(OUTPUT_ENTER_NUMBER);
        print();
    }

    public void gameResultPrint(int strike, int ball) {
        output = new StringBuilder();
        if (ball > ZERO) {
            outputBuilder(ball, OUTPUT_BALL);
        }
        if (strike > ZERO) {
            outputBuilder(strike, OUTPUT_STRIKE);
        }
        if (strike == ZERO && ball == ZERO) {
            output.append(OUTPUT_NOTHING);
        }
        newLine();
        print();
    }

    public void outputBuilder(int judgmentCount, String judgmentString) {
        output.append(judgmentCount).append(judgmentString);
    }
}
