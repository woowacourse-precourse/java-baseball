package baseball.view;

public class ResultView {
    private static final String END_GREETING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    public static void ballProcess(String input){
        System.out.println(input);
    }
    public static void endGreeting() {
        System.out.println(END_GREETING);
    }
}
