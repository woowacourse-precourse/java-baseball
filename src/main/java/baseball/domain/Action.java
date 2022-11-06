package baseball.domain;

public class Action {
    private final String numberAction;
    private final String oneNumberRegularExpression = "[12]";

    public Action(String numberAction) {
        validateForm(numberAction);
        this.numberAction = numberAction;
    }

    private void validateForm(String numberAction) {
        if (!numberAction.matches(oneNumberRegularExpression)) {
            throw new IllegalArgumentException("숫자 1 혹은 2만 입력할 수 있습니다.");
        }
    }
}
