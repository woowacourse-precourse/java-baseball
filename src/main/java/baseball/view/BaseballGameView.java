package baseball.view;

public class BaseballGameView {

    public void gameIntroMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameStartMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void gameResultMessage(Integer strike, Integer ball) {
    }

    public void gameRestartMessage() {
    }
}
