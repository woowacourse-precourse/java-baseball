package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PLEASE_INPUT = "숫자를 입력해주세요 : ";

    public static String inputNumber(){
        System.out.print(PLEASE_INPUT);
        return Console.readLine();
    }
}
