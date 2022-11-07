package baseball.Number;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    CheckException exception = new CheckInputNumberException();

    private String inputNumber;

    public InputNumber() {
        System.out.println("숫자를 입력해주세요");

        this.inputNumber = Console.readLine();
        exception.checkExceoption(inputNumber);

    }
    public String getInputnumber() {
        return inputNumber;
    }

}
