package baseball;

import java.util.List;

public class Hint {
    private final static Integer SIZE = 3;
    private Integer ball;
    private Integer strike;

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public void getHint(List<Integer> user, List<Integer> computer){
        Integer strike = getStrikeCount(user, computer);
        Integer ball = getBallCount(user, computer) - strike;

        this.strike = strike;
        this.ball = ball;
    }
    private Integer getStrikeCount(List<Integer> user, List<Integer> computer){
        Integer strike = 0;
        for(int i = 0; i < SIZE; i++){
            if (user.get(i) == computer.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
    private Integer getBallCount(List<Integer> user, List<Integer> computer){
        Integer ball = 0;
        for (Integer num : user) {
            if (computer.contains(num)){
                ball += 1;
            }
        }
        return ball;
    }
}
