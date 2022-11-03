package baseball;

public class Output {

    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printStrikeMessage(int strike) {
        System.out.println(strike + " 스트라이크");
    }

    public static void printBallMessage(int ball) {
        System.out.println(ball + " 볼");
    }

    public static void printBallAndStrikeMessage(int strike, int ball) {
        System.out.println(ball + " 볼" + " " + strike + " 스트라이크");
    }

    public static void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void RestartGameMessage(int number) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
