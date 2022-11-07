package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public static String playerInputNumber() {
        System.out.println(INPUT_NUMBER);

        String playerNumber = Console.readLine();
        return playerNumber;
    }
}