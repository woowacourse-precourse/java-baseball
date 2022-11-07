package baseball.view;

public class View {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBERS = "숫자를 입력해주세요 : ";

    private View() {}

    public static void printStartGame() {
        System.out.println(START_GAME);
    }

    public static void inputNumbers() {
        System.out.print(INPUT_NUMBERS);
    }
}
