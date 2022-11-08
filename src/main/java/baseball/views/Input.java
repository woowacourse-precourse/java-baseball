package baseball.views;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input(){}

    public static String input() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();

        return number;
    }
}
