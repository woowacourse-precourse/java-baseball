package baseball.Number;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    private String inputNumber;
    private CheckInputNumberException exception = new CheckInputNumberException();

    public void userInputNumber() {
        System.out.println("숫자를 입력해주세요");
        this.inputNumber = Console.readLine();
        exception.checkException(this.inputNumber);
    }

    public String getInputnumber() {
        return inputNumber;
    }

}
