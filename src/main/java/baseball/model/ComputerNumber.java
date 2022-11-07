package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private List<Integer> computerNumbers;
    private static final int MAX_LENGTH = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;


    public void setComputerNumber() {

        computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber(){
        return  computerNumbers;
    }
}
