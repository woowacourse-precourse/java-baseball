package baseball;

import baseball.util.InputOutput;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Player extends InputOutput {

    List<Integer> balls;
    Player(){
        balls = new ArrayList<>();
        generateComputer(balls);
    }
    Player(List<Integer> balls){
        this.balls = balls;
    }

    private void generateComputer(List<Integer> balls){
        while (balls.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber))
                balls.add(randomNumber);
        }
    }

    public List<Integer> getStrikes(Player pitcher){
        int nStrike = 0;
        int nBall = 0;

        for(int i = 0; i < this.balls.size(); i++){
            if(Objects.equals(this.balls.get(i), pitcher.balls.get(i)))
                nStrike++;
            else if(this.balls.contains(pitcher.balls.get(i)))
                nBall++;
        }

        return Arrays.asList(nStrike, nBall);
    }
}