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

            printGuessResult(guessResult,baseball.getBallCount());

            if (guessResult.equals(GuessResult.END)) {
                baseball.chooseContinue();
            }
        }
    }

    public int readGuessNumber(){
        System.out.print(Constant.INPUT_GUESS_NUM);
        return Integer.parseInt(Console.readLine());
    }

    public void printGuessResult(GuessResult guessResult , BallCount ballCount){
        if(guessResult.equals(GuessResult.END)){
            System.out.println(Constant.THREE_STRIKE);

        } else if(guessResult.equals(GuessResult.NOT_SWING)) {
            System.out.println(Constant.NO_BALL_NO_STRIKE);

        } else if(guessResult.equals(GuessResult.ONLY_BALL)) {
            System.out.println(ballCount.getBallCount() + Constant.BALL);

        } else if(guessResult.equals(GuessResult.ONLY_STRIKE)) {
            System.out.println(ballCount.getStrikeCount() + Constant.STRIKE);

        } else if(guessResult.equals(GuessResult.BALL_STRIKE)) {
            System.out.println(ballCount.getBallCount() + Constant.BALL + " " + ballCount.getStrikeCount() + Constant.STRIKE);
        }
    }

}
