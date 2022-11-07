package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static final String RESTART_GAME_CODE = "1";
    private static final String QUIT_GAME_CODE = "2";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String QUIT_OR_RESTART_INPUT_MESSAGE =
            String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RESTART_GAME_CODE, QUIT_GAME_CODE);
    private static final String NUMBER_FORMAT = String.format("[%d-%d]{%d}",
            Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END, Constants.NUMBER_COUNT);

    public String getNumberInput() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();

        return input;
    }

    private boolean isValidFormat(String input) {
        return input.matches(NUMBER_FORMAT);
    }

    public boolean getRestartOrQuitInput() {
        System.out.println(QUIT_OR_RESTART_INPUT_MESSAGE);
        String input = Console.readLine();

        if (input.equals(QUIT_GAME_CODE)) {
            return false;
        }

        return input.equals(RESTART_GAME_CODE);
    }
}
