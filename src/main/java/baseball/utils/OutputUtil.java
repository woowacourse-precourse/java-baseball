package baseball.utils;

public class OutputUtil {

    public static String makeHint(int[] randomNumbers, int input, int index) {
        for (int i = 0; i < 3; i++) {
            if (randomNumbers[i] == input && i == index) {
                return "스트라이크";
            }
            if (randomNumbers[i] == input) {
                return "볼";
            }
        }
        return "낫싱";
    }

    public static String printHint(int strike, int ball) {
        String message = "";
        if (strike == 0 && ball == 0) {
            message = "낫싱";
        }
        if (ball > 0) {
            message = ball + "볼";
        }
        if (strike > 0) {
            message = message + strike + "스트라이크";
        }
        return message;
    }

    private void endingGame(int strike) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
