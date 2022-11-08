package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Referee {

    private int ball;
    private int strike;
    private static final int RESET_TO_ZERO = 0;

    public void initBallAndStrike(){
        ball = RESET_TO_ZERO;
        strike = RESET_TO_ZERO;
    }

    public Integer countStrike(List<Integer> computerList, List<Integer> myList){

        for (int i = 0; i < 3; i++) {
            if(Objects.equals(computerList.get(i), myList.get(i))){
                strike++;
            }
        }

        return strike;
    }

    public Integer countBall(List<Integer> computerList, List<Integer> myList){

        for (int i = 0; i < 3; i++) {
            if(Objects.equals(computerList.get(i), myList.get((i + 1) % 3))){
                ball++;
            }

            if(Objects.equals(computerList.get(i), myList.get((i + 2) % 3))){
                ball++;
            }
        }

        return ball;
    }

}
