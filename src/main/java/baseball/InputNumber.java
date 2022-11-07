package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputNumber {

    private int num;

    public InputNumber() {
        setInputNumber();
    }

    private void setInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        num = Integer.parseInt(readLine());
        if (num < 100 || num > 999) {
            throw new IllegalArgumentException();
        }
    }

    public int getInputNumber() {
        return num;
    }
}
