package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputNum implements Input {

    @Override
    public String input(int size) {
        final String INPUT_TEXT = "숫자를 입력해주세요 : ";
        String inputNum;
        System.out.print(INPUT_TEXT);
        inputNum = Console.readLine();
        validateInput(inputNum, size);
        return inputNum;
    }

    @Override
    public void validateInput(String input, int size) {
        Pattern p = Pattern.compile("[1-9]{" + size + "}");

        if (!p.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }

        if (isDuplicated(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(String input) {
        Set<String> deduplicatedSet = new HashSet<>();
        String[] inputArr = input.split("");
        for (String str : inputArr) {
            deduplicatedSet.add(str);
        }
        int inputLength = input.length();
        if (deduplicatedSet.size() != inputLength) {
            return true;
        }

        return false;
    }
}
