package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayerInputView {
    public static final String INPUT_MESSAGE = "\n숫자를 입력해주세요 : ";
    public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String startInput() {
        System.out.print(INPUT_MESSAGE);
        String inputNum = Console.readLine();
        CheckException.validationNumber(inputNum);
        return inputNum;
    }

    public static String restartGame() {
        System.out.println(RESTART_MESSAGE);
        String inputNum = Console.readLine();
        CheckException.checkRestartNumber(inputNum);
        return inputNum;
    }
}
