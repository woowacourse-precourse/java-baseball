package baseball;

public class Baseball {
    private static BaseballResult baseballResult;

    Baseball() {
        baseballResult = new BaseballResult();
    }

    public void play() {
        BaseballNumber computerNumbers = BaseballNumber.getComputerPickedNumbers();
        boolean isAllStrike;
        do {
            BaseballNumber userNumber = BaseballInput.getUserNumber();
            BaseballScore roundScore = baseballResult.getBaseballScore(computerNumbers, userNumber);
            System.out.println(roundScore.toString());
            isAllStrike = roundScore.isAllStirke();
        } while (!isAllStrike);
    }


}
