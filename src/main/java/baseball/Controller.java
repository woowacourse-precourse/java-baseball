package baseball;

public class Controller {

    private GuessResult guessResult;
    private Baseball baseball;

    public void runBaseball(){
        baseball = new Baseball();
        baseball.start();

        while (baseball.isGaming()) {
            baseball.setGuessNumber();

            guessResult = baseball.getGuessResult();
            if (guessResult.equals(GuessResult.END)) {
                baseball.chooseContinue();
            }
        }
    }

}
