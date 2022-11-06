package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputNum {
    static final String INPUT_TEXT = "숫자를 입력해주세요 : ";

    String input(int size) {
        String inputNum;
        System.out.println(INPUT_TEXT);
        inputNum = Console.readLine();
        validateInuput(inputNum, size);
        return inputNum;
    }

    private void validateInuput(String input, int size) {
        Pattern p = Pattern.compile("[0-9]{"+size+"}");
        if (!p.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
