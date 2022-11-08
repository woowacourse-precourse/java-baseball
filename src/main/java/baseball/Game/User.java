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

}
