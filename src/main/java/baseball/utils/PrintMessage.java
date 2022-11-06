package baseball.utils;

public class PrintMessage {

    public void gameStartNotice() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void inputRequest() {
        System.out.println("숫자를 입력해 주세요 : ");
    }

    public void Status(int ball, int strike) {
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
    }

}
