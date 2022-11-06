package baseball;

public class InGame {
    private final BaseballUtil baseballUtil;
    private final int answer;

    public InGame() {
        this.baseballUtil = new BaseballUtil();
        this.answer = this.createRandomInt();
    }
    public InGame(BaseballUtil baseballUtil) {
        this.baseballUtil = baseballUtil;
        this.answer = this.createRandomInt();
    }

    public InGame(BaseballUtil baseballUtil, int number) {
        this.baseballUtil = baseballUtil;
        this.answer = number;
    }

    public boolean playGame() {

    }

    private int createRandomInt() {

    }

    private void announceUserInput() {

    }

    private void announceInputResult() {

    }

    private int getUserInput() {

    }

    private boolean userInputValidation() {

    }

    private int compareUserInput() {

    }
}
