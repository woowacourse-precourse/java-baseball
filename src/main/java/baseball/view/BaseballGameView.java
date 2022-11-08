package baseball.view;

public class BaseballGameView {

    public void gameIntroMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameStartMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void gameResultMessage(Integer strike, Integer ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public void gameRestartMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
