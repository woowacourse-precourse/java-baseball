package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String userNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userNumberOfString = Console.readLine();
        return userNumberOfString;
    }
}
