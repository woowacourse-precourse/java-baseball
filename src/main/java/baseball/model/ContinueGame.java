package baseball.model;

public class ContinueGame {
    private static final String CONTINUE_ERROR_MESSAGE = "한 자리 숫자 1, 2 이외의 값이 들어갔습니다.";

    private ContinueGame() {
    }

    public static ContinueGame getInstance() {
        return new ContinueGame();
    }

    public boolean selectContinueGame(String inputToSelectContinueGame) {
        validateContinueInput(inputToSelectContinueGame);

        boolean continueGame = isContinueGame(inputToSelectContinueGame);
        return continueGame;
    }

    private void validateContinueInput(String inputToSelectContinueGame){
        String pattern = "[1-2]";
        if (!inputToSelectContinueGame.matches(pattern)) {
            throw new IllegalArgumentException(CONTINUE_ERROR_MESSAGE);
        }
    }

    private boolean isContinueGame(String inputToSelectContinueGame) {
        if (inputToSelectContinueGame.equals("2")) {
            return false;
        }
        return true;
    }
}
