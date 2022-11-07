package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    public boolean restartQuestion() {
        ErrorUtil errorUtil = new ErrorUtil();
        boolean restart = false;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();
        errorUtil.checkError(errorUtil.checkErrorRestartNumber(number));
        if (number.charAt(0) == '1')
            restart = true;
        return restart;
    }
    public String inputPlayerNumber() {
        ErrorUtil errorUtil = new ErrorUtil();
        String number = Console.readLine();
        errorUtil.checkError(errorUtil.errorPlayerNumber(number));
        return number;
    }
}