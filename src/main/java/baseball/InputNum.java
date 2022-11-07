package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputNum implements Input{
    static final String INPUT_TEXT = "숫자를 입력해주세요 : ";

    @Override
    public String input(int size) {
        String inputNum;
        System.out.print(INPUT_TEXT);
        inputNum = Console.readLine();
        validateInput(inputNum, size);
        return inputNum;
    }

    @Override
    public void validateInput(String input, int size) {
        Pattern p = Pattern.compile("[1-9]{"+size+"}");
        if (!p.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
