package baseball.domain;

public class Action {
    private final String numberAction;
    private static final String ONE_NUMBER_REGULAR_EXPRESSION = "[12]";
    public static final String EXCEPTION_MESSAGE_FOR_INVALID_FORM = "숫자 1 혹은 2만 입력할 수 있습니다.";
    public static final String START = "1";
    public static final String END = "2";

    public Action(String numberAction) {
        validateForm(numberAction);
        this.numberAction = numberAction;
    }

    private void validateForm(String numberAction) {
        if (!numberAction.matches(ONE_NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_INVALID_FORM);
        }
    }

    public boolean isStart() {
        return numberAction.equals(START);
    }
}
