package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    private static String INPUT_PHRASES = "숫자를 입력해주세요 : ";
    private static String END_PHRASES = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static String COMPLETE_PHRASES = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static String inputView() {
        System.out.println(INPUT_PHRASES);
        return readLine();
    }

    public static String endView() {
        System.out.println(END_PHRASES);
        return readLine();
    }

    public static void resultView(int strike, int ball) {
        if(ball != 0) System.out.print(ball + "볼");
        if(strike != 0) System.out.print(strike + "스트라이크");
        if(ball == 0 && strike == 0) System.out.print("낫싱");
        System.out.println();
    }

    public static void completeView(int length) {
        System.out.println(length + COMPLETE_PHRASES);
    }
}
