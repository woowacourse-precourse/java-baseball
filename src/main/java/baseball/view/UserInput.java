package baseball.view;

import static java.lang.System.out;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public static String InputUserNumbers() {
        out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String SelectRestartOrExit() {
        out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
