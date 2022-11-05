package baseball.domain.view;

import baseball.domain.util.Util;

public class InputView {
    private static final String inputNumbers = "숫자를 입력해주세요 : ";

    public static String printNumbers() {
        System.out.print(inputNumbers);
        return Util.input();
    }
}
