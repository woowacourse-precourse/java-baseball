package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Ball {

    private List <Integer> ball;

    public Ball(){

    }

    public void makeComputerBalls(){
        List<Integer> comBall = new ArrayList<>();
        while (comBall.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comBall.contains(randomNumber)) {
                comBall.add(randomNumber);
            }
        }
        this.ball=comBall;
    }


}
