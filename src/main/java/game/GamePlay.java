package game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    private static final int ANSWER_START_NUMBER = 1;
    public static final int ANSWER_END_NUMBER = 9;
    public static List<Integer> getAnswer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(ANSWER_START_NUMBER, ANSWER_END_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
