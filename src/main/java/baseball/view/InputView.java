package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputNumberMessage() {
        System.out.printf("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
