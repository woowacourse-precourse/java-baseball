package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_PLAYER_ANSWER = "숫자를 입력해주세요 : ";

    public static String requestPlayerInput() {
        System.out.print(INPUT_PLAYER_ANSWER);
        String playerInput = Console.readLine();
        return playerInput;
    }
}
