package baseball.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }
}
