package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Controller {

    private GuessResult guessResult;
    private Baseball baseball;

    public void runBaseball(){
        baseball = new Baseball();
        baseball.start();

        while (baseball.isGaming()) {
            baseball.setGuessNumber(readGuessNumber());

            guessResult = baseball.getGuessResult();
            if (guessResult.equals(GuessResult.END)) {
                baseball.chooseContinue();
            }
        }
    }

    public int readGuessNumber(){
        System.out.print(Constant.INPUT_GUESS_NUM);
        return Integer.parseInt(Console.readLine());
    }

}
