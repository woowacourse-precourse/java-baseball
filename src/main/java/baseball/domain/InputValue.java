package baseball.domain;

import baseball.exception.InputException;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValue {
    InputException validation = new InputException();
    private String input;

    public List<Integer> inputNum() {
        System.out.print("숫자를 입력해 주세요 : ");
        input = readLine().replaceAll("\\s", "");

        validation.isNumber(input);

        List<Integer> inputNumber = returnList(input);

        return inputNumber;
    }

    public List<Integer> returnList(String inputNum) {
        List<Integer> list = new ArrayList<>();

        for (int idx = 0; idx < inputNum.length(); idx++) {
            list.add(Integer.parseInt(
                    String.valueOf(inputNum.charAt(idx))));
        }

        return list;
    }
}
