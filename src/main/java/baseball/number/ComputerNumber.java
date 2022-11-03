package baseball.number;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber {
    private List<Integer> computerNumber;

    public ComputerNumber(){
        computerNumber = new ArrayList<>();
    }

    public List<Integer> generateNumber() {
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
