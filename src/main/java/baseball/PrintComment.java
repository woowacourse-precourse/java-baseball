package baseball;

public class PrintComment {
    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_COMMENT = "숫자를 입력해주세요 : ";

    public static void printStartComment() {
        System.out.println(START);
    }

    public static void printInputComment() {
        System.out.println(INPUT_COMMENT);
    }

    public static void printUserInput(String numbers) {
        System.out.println(numbers);
    }
}