package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void getInputMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public String inputNumbers() {
        return Console.readLine();
    }

}
