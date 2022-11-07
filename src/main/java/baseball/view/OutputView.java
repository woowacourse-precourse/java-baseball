package baseball.view;

public class OutputView {
    private final static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
