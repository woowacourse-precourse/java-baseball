package baseball;

public class Play {
    public void game() {
        String computerNumber = Computer.number();
        boolean endGameCheck;

        do {
            String userNumber = User.number();
            BaseballGame baseballGame = new BaseballGame(userNumber, computerNumber);
            baseballGame.isBall();
            baseballGame.isStrike();
            baseballGame.printResult();
            endGameCheck = baseballGame.isThreeStrike();
        } while(!endGameCheck);
    }
}
