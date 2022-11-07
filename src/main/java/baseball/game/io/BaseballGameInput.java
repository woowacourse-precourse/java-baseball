package baseball.game.io;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameInput {

    public static String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    private static String readLine() {
        return Console.readLine();
    }

}
