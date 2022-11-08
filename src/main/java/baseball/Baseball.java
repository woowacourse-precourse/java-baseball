package baseball;

public class Baseball {
    private static BaseballResult baseballResult;

    Baseball() {
        baseballResult = new BaseballResult();
    }

    public void play() {
        BaseballNumber computerNumbers = BaseballNumber.getComputerPickedNumbers();
        boolean is_all_strike;
        do {
            BaseballNumber userNumber = BaseballInput.getUserNumber();
            BaseballScore roundScore = baseballResult.getBaseballScore(computerNumbers, userNumber);
            System.out.println(roundScore.toString());
            is_all_strike = roundScore.is_all_strike();
        } while (!is_all_strike);
    }


}
