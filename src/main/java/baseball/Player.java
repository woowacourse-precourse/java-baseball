package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private Validator validator = new Validator();

    public String getNumberInput() {
        System.out.print(Message.INPUT_NUMBER.message());
        String input = Console.readLine();

        validator.checkValidNumberInput(input);

        return input;
    }

    public boolean getRestartOrQuitInput() {
        System.out.println(Message.INPUT_QUIT_OR_RESTART.message());
        String input = Console.readLine();

        validator.checkValidRestartOrQuitInput(input);

        return input.equals(Constants.RESTART_GAME_CODE);
    }

    private enum Message {
        INPUT_NUMBER("숫자를 입력해주세요 : "),
        INPUT_QUIT_OR_RESTART(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
                Constants.RESTART_GAME_CODE, Constants.QUIT_GAME_CODE))
        ;
        private final String message;

        Message(String message) {
            this.message = message;
        }

        private String message() {
            return message;
        }
    }
}
