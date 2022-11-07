package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static String startInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
