package baseball.view;

import baseball.domain.Hint;

public class View {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_RESET = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private View() {}

    public static void printStartGame() {
        System.out.println(START_GAME);
    }

    public static void inputNumbers() {
        System.out.print(INPUT_NUMBERS);
    }

    public static void printGameOver() {
        System.out.println(GAME_OVER);
        System.out.println(INPUT_RESET);
    }

    public static void printHint() {
        System.out.println(Hint.getHintByCount());
    }
}
