package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private InputNumber inputNumber;

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = new InputNumber(Console.readLine());

        return inputNumber.number;
    }
}
