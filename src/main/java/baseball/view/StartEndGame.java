package baseball.view;

import java.io.IOException;

public class StartEndGame extends Game{
    public void startGame() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("숫자 야구 게임을 시작합니다.\n");
        print(sb.toString());
    }
    public void endGame() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        sb.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        print(sb.toString());
    }

}
