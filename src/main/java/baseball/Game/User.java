package baseball.Game;

public class User {

    public static void UserInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void UserOutput(int ball, int strike) {
        if (strike == 0) {
            System.out.println("낫싱");
        }
        if (0 < strike && strike < 3) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike == 3) {
            System.out.println(strike + "스트라이크");
        }
    }

    public void correctAnsMsg() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void retryMsg() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
