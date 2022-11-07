package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class SystemInputView {

    public static String startInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String endInput() {
        System.out.print("1이나 2를 입력해주세요.");
        return Console.readLine();
    }

}
