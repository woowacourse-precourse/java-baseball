package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    public void restartQuestion() {
        ErrorUtil errorUtil = new ErrorUtil();
        PrintUtil printUtil = new PrintUtil();
        RestartUtil restartUtil = new RestartUtil();
        printUtil.printRestart();
        String number = Console.readLine();
        errorUtil.checkError(errorUtil.checkErrorRestartNumber(number));
        if (number.charAt(0) == '1')
            restartUtil.restartGame();
    }
    public String inputPlayerNumber() {
        ErrorUtil errorUtil = new ErrorUtil();
        String number = Console.readLine();
        errorUtil.checkError(errorUtil.errorPlayerNumber(number));
        return number;
    }
}