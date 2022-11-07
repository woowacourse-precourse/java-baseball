package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {
    static final int MINIMUM_RANGE = 0;
    static final int MAXIMUM_RANGE = 9;
    static final int RANDOM_NUMBER_SIZE = 3;
    
    private List<Integer> targetRandomNumber = new ArrayList<>();

    public Computer() {
    }

    public void pickRandomNumber(){
        while (targetRandomNumber.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANGE, MAXIMUM_RANGE);
            if (!targetRandomNumber.contains(randomNumber)) {
                targetRandomNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getTargetRandomNumber() {
        return targetRandomNumber;
    }
}
