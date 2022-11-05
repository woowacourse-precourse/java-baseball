package baseball;

public class Controller {

    public void runBaseball(){
        Baseball baseball = new Baseball();
        baseball.start();
        while (baseball.isGaming()) {
            baseball.setGuessNumber();

            GuessResult guessResult = baseball.getGuessResult();
            if (guessResult.equals(GuessResult.END)) {
                baseball.chooseContinue();
            }
        }
    }

}
