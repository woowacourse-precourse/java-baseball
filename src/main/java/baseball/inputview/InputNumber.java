package baseball.inputview;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {

    public String run() {
        printMessage();
        return input();
    }

    public void printMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }
    public String input() {
        return Console.readLine();
    }
}
