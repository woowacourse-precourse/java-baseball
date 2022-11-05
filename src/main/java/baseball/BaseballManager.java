package baseball;

public class BaseballManager {
    BaseballNumber userNumber;
    BaseballNumber computerNumber;
    ScoreManager scoreManager;

    {
        computerNumber = new BaseballNumber(
                RandomNumGenerator.makeRandomNumWithNDigits(SystemConstant.GAME_DIGIT));
    }

    void addUserBaseballNumInfo(BaseballNumber baseballNum1) {
        userNumber = baseballNum1;
    }

}
