package baseball.domain.view;

public class OutputView {
    public static final String startGame = "숫자 야구 게임을 시작합니다.";

    public static void printStart() {
        System.out.println(startGame);
    }

    public static boolean printResult(int strike, int ball) {
        String answer;

        if (ball > 0 && strike > 0) answer = ball + "볼 " + strike + "스트라이크";
        else {
            if (ball > 0) answer = ball + "볼";
            else if (strike > 0) answer = strike + "스트라이크";
            else answer = "낫싱";
        }

        System.out.println(answer);

        return strike == 3;
    }

    public static void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
