package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    private InputController() {
    }

    public static void validateFlagNum(String input) {
        if (!input.matches("[^\\d+$]")
                || !(Integer.parseInt(input) == 1 || Integer.parseInt(input) == 2)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static int getExitFlag() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

}
