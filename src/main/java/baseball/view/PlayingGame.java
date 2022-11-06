package baseball.view;

import java.io.IOException;

public class PlayingGame extends Game{
    public void enterNumber() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("숫자를 입력해주세요 : ");
        print(sb.toString());
    }
    public void gameResult (int strike, int ball) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball + "볼 ");
        }
        if (strike > 0) {
            sb.append(strike + "스트라이크 ");
        }
        sb.append("\n");
        print(sb.toString());
    }
}
