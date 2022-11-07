package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private final static int RANDOM_NUMBER_COUNT = 3;
    private final static int RANDOM_NUMBER_MIN = 1;
    private final static int RANDOM_NUMBER_MAX = 9;

    public static List<Integer> gameRandomNumber(){
        List<Integer> randomNumberList = createRandomNumber(); // 난수 생성
        return randomNumberList;
    }

    public static List<Integer> createRandomNumber(){

        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < RANDOM_NUMBER_COUNT) {
            randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
