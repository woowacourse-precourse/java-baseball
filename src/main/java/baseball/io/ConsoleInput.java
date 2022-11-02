package baseball.io;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private static final String INPUT_NUMBER_PROMPT = "숫자를 입력해 주세요 : ";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputNumber() {
        System.out.print(INPUT_NUMBER_PROMPT);

        return scanner.nextLine();
    }
}
