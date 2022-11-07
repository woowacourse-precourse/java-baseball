package baseball.domain;

public class Action {
    private final String numberAction;
    private final String ONE_NUMBER_REGULAR_EXPRESSION = "[12]";
    private final String RESTART = "1";

    public Action(String numberAction) {
        validateForm(numberAction);
        this.numberAction = numberAction;
    }

    private void validateForm(String numberAction) {
        if (!numberAction.matches(ONE_NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("숫자 1 혹은 2만 입력할 수 있습니다.");
        }
    }

    public boolean isRestart() {
        return numberAction.equals(RESTART);
    }
}
