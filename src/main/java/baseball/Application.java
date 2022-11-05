package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Baseball baseball = new Baseball();
        baseball.start();
        while (baseball.isGaming()){
            try{
                baseball.setGuessNumber();
            } catch (IllegalArgumentException ie){
                return;
            }

            System.out.println(baseball);
            GuessResult guessResult = baseball.getGuessResult();
            if (guessResult.equals(GuessResult.BALL_STRIKE)){
                continue;
            } else if(guessResult.equals(GuessResult.NOT_SWING)){
                continue;
            } else if(guessResult.equals(GuessResult.END)){
                baseball.chooseContinue();
                System.out.println(baseball.isGaming());
            }
        }

        return;
    }
}
