package baseball.enums;

import java.util.List;
import java.util.function.Function;

public enum InputValidation {
    BLANK_INPUT(
            "아무것도 입력하지 않았습니다.",
            List.of(1,2),
            String::isBlank
    ),
    NOT_THREE_LENGTH(
            "세 자리가 아닙니다.",
            List.of(1),
            value -> value.length() != 3
    ),
    NOT_NUMBER_OR_CONTAINS_0(
            "숫자가 아니거나 0이 포함되어 있습니다",
            List.of(1),
            value -> !value.matches("^[1-9]*$")
    ),
    DUPLICATED(
            "중복된 숫자가 포함되어 있습니다.",
            List.of(1),
            value -> value.matches("^.(.)\\1$") || value.matches("^(.)\\1.$") || value.matches("^(.).\\1$")
    ),
    NOT_ONE_OR_TWO(
            "1 또는 2를 입력해야 합니다.",
            List.of(2),
            value -> !value.matches("^[12]$")
    );

    private final String errorMessage;
    private final List<Integer> group;
    private final Function<String, Boolean> expression;

    InputValidation(String errorMessage, List<Integer> group, Function<String, Boolean> expression) {
        this.errorMessage = errorMessage;
        this.group = group;
        this.expression = expression;
    }

    public String message() {
        return errorMessage;
    }

    public List<Integer> getGroup() {
        return group;
    }

    public boolean validate(String input) {
        return expression.apply(input);
    }
}
