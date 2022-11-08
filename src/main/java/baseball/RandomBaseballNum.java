package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBaseballNum{
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBER_SIZE = 3;
    public static List<Integer> randomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE){
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}