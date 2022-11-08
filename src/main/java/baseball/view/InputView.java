package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final int CONTINUE = 1;
    private static final int STOP = 2;

    private InputView() {
    }

    public static String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static int inputContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int command = Integer.parseInt(Console.readLine());
        validate(command);
        return command;
    }

    private static void validate(int command) {
        if (!isValidCommand(command)) {
            throw new IllegalArgumentException("1과 2 중에서 선택해주세요.");
        }
    }

    private static boolean isValidCommand(int command) {
        return command == CONTINUE || command == STOP;
    }
}
