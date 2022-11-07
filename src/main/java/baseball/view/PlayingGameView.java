package baseball.view;

public class PlayingGameView extends GameView {
    private static final String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String OUTPUT_BALL = "볼 ";
    private static final String OUTPUT_STRIKE = "스트라이크";
    private static final String OUTPUT_NOTHING = "낫싱";
    public void enterNumberPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(OUTPUT_ENTER_NUMBER);
        print(sb.toString());
    }

    public void gameResultPrint(int strike, int ball) {
        StringBuilder output = new StringBuilder();
        if (ball > 0) {
            output.append(ball + OUTPUT_BALL);
        }
        if (strike > 0) {
            output.append(strike + OUTPUT_STRIKE);
        }
        if (strike == 0 && ball == 0) {
            output.append(OUTPUT_NOTHING);
        }
        newLine(output);
        print(output.toString());
    }
}
