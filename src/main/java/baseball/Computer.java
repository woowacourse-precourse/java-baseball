package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    public String makeRandomBall() {
        Set <Integer> randomBallSet = new HashSet <>();
        StringBuilder sb = new StringBuilder();

        while(randomBallSet.size() < 3){
            randomBallSet.add(Randoms.pickNumberInRange(1, 9));
        }

        randomBallSet.forEach(sb::append);
        return sb.toString();
    }
}
