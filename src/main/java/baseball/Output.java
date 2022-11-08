package baseball;

public class Output {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printStrikeBall(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static void printStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void printBall(int ball) {
        System.out.println(ball + "볼");
    }

    public static void printFourBall() {
        System.out.println("낫싱");
    }

    public static void printCorrectAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
