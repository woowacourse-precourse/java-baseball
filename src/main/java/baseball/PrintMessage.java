package baseball;

public class PrintMessage {

    public static void printStartBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printHintBall(int numberOfBall) {
        if (numberOfBall != 0) {
            System.out.printf("%d볼 ", numberOfBall);
        }
    }

    public static void printHintStrike(int numberOfStrike) {
        if (numberOfStrike != 0) {
            System.out.printf("%d스트라이크 ", numberOfStrike);
        }
    }

}
