package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestNum() {
        OutputView.printRequestNum();
        String input = Console.readLine();

        return input;
    }
}
