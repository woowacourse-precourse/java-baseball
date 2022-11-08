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

    public static void printHintNothing(int numberOfStrike, int numberOfBall) {
        if (numberOfStrike == 0 && numberOfBall == 0) {
            System.out.print("낫싱");
        }
    }

    public static void printHint(int numberOfStrike, int numberOfBall) {
        printHintBall(numberOfBall);
        printHintStrike(numberOfStrike);
        printHintNothing(numberOfStrike, numberOfBall);
        System.out.println();
    }

    public static void printCorrectAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printReGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
