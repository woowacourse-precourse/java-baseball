package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String selectUserNumberInput() {
        System.out.print("숫자를 입력해주세요: ");
        return InputException.validUserNumberException(Console.readLine());
    }

    public static boolean selectEndOrRestartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return getEndOrRestart();
    }

    private static boolean getEndOrRestart() {
        if (Console.readLine().equals("1")) {
            return true;
        }
        return false;
    }
}
