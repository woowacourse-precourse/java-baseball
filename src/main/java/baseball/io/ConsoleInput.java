package baseball.io;

import camp.nextstep.edu.missionutils.Console;


public class ConsoleInput implements Input {
    private static final String INPUT_NUMBER_PROMPT = "숫자를 입력해 주세요 : ";

    @Override
    public String inputNumber() {
        System.out.print(INPUT_NUMBER_PROMPT);

        return Console.readLine();
    }

    @Override
    public String userInput() {
        return Console.readLine();
    }
}
