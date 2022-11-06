package baseball.model;

import baseball.system.SystemValue;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User {
    private List<Integer> inputNumberList;

    public User(String input) {
        this.inputNumberList = getValidList(input);
    }

    private List<Integer> getValidList(String input) {
        if (!isNumberOfString(input)) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputNumberList = parseIntegerList(input);

        if (!isThreeInSize(inputNumberList) || !isComposedUniqueNumber(inputNumberList) || !isNumberFromOneToNine(
                inputNumberList)) {
            throw new IllegalArgumentException();
        }
        return inputNumberList;
    }

    private boolean isNumberOfString(String text) {
        Pattern pattern = Pattern.compile(SystemValue.REGAX_ONLY_NUMBER);
        return pattern.matcher(text).matches();
    }

    private List<Integer> parseIntegerList(String text) {
        return Arrays.stream(text.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private boolean isThreeInSize(List<Integer> numberList) {
        return numberList.size() == SystemValue.DIGIT_SIZE;
    }

    private boolean isComposedUniqueNumber(List<Integer> numberList) {
        return numberList.stream().distinct().count() == numberList.size();
    }

    private boolean isNumberFromOneToNine(List<Integer> numberList) {
        for (int number : numberList) {
            if (number < SystemValue.MINIMUM_RANGE || number > SystemValue.MAXIMUM_RANGE) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getInputNumberList() {
        return inputNumberList;
    }
}
