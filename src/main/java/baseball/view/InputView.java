package baseball.view;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String setPlayerNumber() {
        System.out.print(Constant.INPUT_USER_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static int setNumberRestartOrEndGame() {

        return Integer.parseInt(Console.readLine());
    }
}
