package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static boolean inputReplay() {
        int replay = Integer.parseInt(Console.readLine());
        return Validate.isCommandValid(replay);
    }
}
