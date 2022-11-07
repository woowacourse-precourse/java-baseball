package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

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

    private void checkValidNumberInput(String input) {
        if (!isValidFormat(input)) {
            throw new IllegalArgumentException("1-9사이의 숫자 3개를 입력해주세요.");
        }
        if (!isAllDifferent(input)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }

    private boolean isValidFormat(String input) {
        return input.matches(NUMBER_FORMAT);
    }

    private boolean isAllDifferent(String input) {
        HashSet<Character> hs = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!hs.add(c)) {
                return false;
            }
        }

        return true;
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
