package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public String getNumberInput() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();

        return input;
    }
}
