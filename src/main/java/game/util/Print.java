package game.util;

public class Print {
    public static final String GETTING_START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    public static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String AFTER_ROUND = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printGettingStart() {
        System.out.println(GETTING_START);
    }

    public static void printReadNumbers() {
        System.out.println(INPUT_NUMBERS);
    }

    public static void printGameOverAndAfterRound() {
        System.out.println(GAME_OVER);
        System.out.println(AFTER_ROUND);
    }
}
