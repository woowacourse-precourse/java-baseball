package baseball.view;

public class SystemMessage {
    public static void getStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }
    public static void getInputMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }
    public static void getCorrectMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static void chooseRestartExit() {System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하게요.");}
    public static void getScoreMessage(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
