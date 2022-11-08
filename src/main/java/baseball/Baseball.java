package baseball;

public class Baseball {

    public void play() {
        BaseballNumber computerNumbers = BaseballNumber.getComputerPickedNumbers();
        boolean isAllStrike;
        do {
            BaseballNumber userNumber = BaseballInput.getUserNumber();
            BaseballScore roundScore = BaseballResult.getBaseballScore(computerNumbers, userNumber);
            System.out.println(roundScore.toString());
            isAllStrike = roundScore.isAllStirke();
        } while (!isAllStrike);
    }


}
