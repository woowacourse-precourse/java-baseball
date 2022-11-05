package baseball.util.input;

public class ContinueInput implements UserInput {
    private final String continueInput;
    private final int CONTINUE_GAME = '1';
    private final int EXIT_GAME = '2';

    public ContinueInput() {
        continueInput = get();
    }

    @Override
    public void validate(String input) {
        if (input.length() > 1) {
            throw new IllegalArgumentException("길이 1초과");
        } else if (!(input.charAt(0) == CONTINUE_GAME || input.charAt(0) == EXIT_GAME)) {
            throw new IllegalArgumentException("1혹은 2만 입력");
        }
    }

    public boolean continueGame() {
        if (continueInput.charAt(0) == '1') {
            return true;
        }
        return false;
    }

}
