package baseball;


public class Console {

    public static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String inputUserBalls() {
        System.out.print("숫자를 입력하세요 : ");
        String userBalls = camp.nextstep.edu.missionutils.Console.readLine();
        Exception.check(userBalls);

        return userBalls;
    }

    public static void printHint(int strike, int ball) {
        String hintMessage = "";

        if (ball > 0 && strike > 0) {
            hintMessage = ball + "볼 " + strike + "스트라이크";
        } else if (strike > 0) {
            hintMessage = strike + "스트라이크";
        } else if (ball > 0) {
            hintMessage = ball + "볼";
        } else if (strike == 0 && ball == 0) {
            hintMessage = "낫싱";
        }

        System.out.println(hintMessage);
    }
}
