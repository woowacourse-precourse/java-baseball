package baseball;

public class BaseballReferee {

    private BaseballInput answer;

    BaseballReferee(BaseballInput answer) {
        this.answer = answer;

    }

    public BaseballOutput judge(BaseballInput target) {
        int ball = 0;

        if (answer.isBall(target.getFirst())) {
            ball++;
        }
        if (answer.isBall(target.getSecond())) {
            ball++;
        }
        if (answer.isBall(target.getThird())) {
            ball++;
        }
        int strike = answer.getStrikeNumber(target);
        ball -= strike;


        return new BaseballOutput(ball, strike);
    }
}
