package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class Player {
    private static final String RESTART_GAME_CODE = "1";
    private static final String QUIT_GAME_CODE = "2";
    private static final String NUMBER_FORMAT = String.format("[%d-%d]{%d}",
            Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END, Constants.NUMBER_COUNT);

    public String getNumberInput() {
        System.out.print(Message.INPUT_NUMBER.message());
        String input = Console.readLine();

        checkValidNumberInput(input);

        return input;
    }

    private void checkValidNumberInput(String input) {
        if (!isValidFormat(input)) {
            throw new IllegalArgumentException(Message.ERROR_NUMBER_WRONG_FORMAT.message());
        }
        if (!isAllDifferent(input)) {
            throw new IllegalArgumentException(Message.ERROR_NUMBER_SAME_NUMBER.message());
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
        System.out.println(Message.INPUT_QUIT_OR_RESTART.message());
        String input = Console.readLine();

        checkValidRestartOrQuitInput(input);

        if (input.equals(QUIT_GAME_CODE)) {
            return false;
        }

        return input.equals(RESTART_GAME_CODE);
    }

    private void checkValidRestartOrQuitInput(String input) {
        if (!input.equals(RESTART_GAME_CODE) && !input.equals(QUIT_GAME_CODE)) {
            throw new IllegalArgumentException(Message.ERROR_QUIT_OR_RESTART.message());
        }
    }

    private enum Message {
        INPUT_NUMBER("숫자를 입력해주세요 : "),
        INPUT_QUIT_OR_RESTART(
                String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RESTART_GAME_CODE, QUIT_GAME_CODE)),
        ERROR_NUMBER_WRONG_FORMAT(String.format("[%d-%d]{%d}",
                Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END, Constants.NUMBER_COUNT)),
        ERROR_NUMBER_SAME_NUMBER(String.format("%d-%d 사이의 숫자 %d개를 입력해주세요.",
                Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END, Constants.NUMBER_COUNT)),
        ERROR_QUIT_OR_RESTART(String.format("%s, %s 중 하나의 수를 입력해주세요.", RESTART_GAME_CODE, QUIT_GAME_CODE))
        ;

        private final String message;
        Message(String message) {
            this.message = message;
        }
        private String message(){
            return message;
        }
    }
}
