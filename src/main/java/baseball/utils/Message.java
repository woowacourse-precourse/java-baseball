package baseball.utils;

public class Message {
    public static void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printEndGame(int digit) {
        System.out.println(digit + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printEndProgram() {
        System.out.println("게임 종료");
    }

    public static void printReplayGame(int RETRY_OK, int RETRY_NO) {
        System.out.println("게임을 새로 시작하려면 " + RETRY_OK + ", 종료하려면 " + RETRY_NO + "를 입력하세요.");
    }

    public static void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printScore(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
