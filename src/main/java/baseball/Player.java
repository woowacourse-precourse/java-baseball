package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    static InputNumber inputNumber;

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = new InputNumber(Console.readLine());

        return InputNumber.number;
    }

    public List<String> splitInputNumberToList() {
        String[] strArr = InputNumber.number.split("");
        List<String> inputNumberList = new ArrayList<>(Arrays.asList(strArr));

        return inputNumberList;
    }
}
