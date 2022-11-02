package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public enum InputView {
    INSTANCE;

    private static final String INPUT_BASEBALL_NUMBER = "숫자를 입력해주세요 : ";

    public String inputBaseballNumber() {
        System.out.println(INPUT_BASEBALL_NUMBER);
        return Console.readLine();
    }
}
