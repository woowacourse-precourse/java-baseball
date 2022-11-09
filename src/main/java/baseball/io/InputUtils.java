package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {

    private static final String INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_GUIDE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String askWhetherToRestart() {
        System.out.println(RESTART_GUIDE_MESSAGE);
        return Console.readLine();
    }

    public static String readNumbersWrittenByUser() {
        System.out.print(INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }
}
