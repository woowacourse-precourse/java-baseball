package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int BallsLength = 3;

    public static List<Integer> makeBalls(){
        List<Integer> computerBalls = new ArrayList<>();

        while(computerBalls.size()<BallsLength){
            int randomBall = Randoms.pickNumberInRange(1,9);

            if(!computerBalls.contains(randomBall)){
                computerBalls.add(randomBall);
            }
        }
        return computerBalls;
    }
}
