package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber;

    public List<Integer> getComputerNumber() {
        setComputerNumber(makeComputerNumber());
        return computerNumber;
    }

    public void setComputerNumber(List<Integer> computerNumber) {
        this.computerNumber=computerNumber;
    }

    public List<Integer> makeComputerNumber(){
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
