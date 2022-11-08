package baseball;

public class Baseball {
    private int round;
    private final BaseballNumber computerNumbers;

    Baseball() {
        round = 0;
        computerNumbers = BaseballNumber.getComputerPickedNumbers();
    }

    public void playGame() {
        boolean isAllStrike = false;

        while (!isAllStrike) {
            round += 1;
            BaseballScore score = playRound();
            System.out.println(score.toString());
            isAllStrike = score.isAllStirke();

        }
    }

    public BaseballScore playRound() {
        BaseballNumber userNumber = BaseballInput.getUserNumber();
        return BaseballResult.getBaseballScore(computerNumbers, userNumber);
    }


}
