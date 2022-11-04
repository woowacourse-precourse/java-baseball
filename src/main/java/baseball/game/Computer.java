package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static final int COMPUTER_NUMBER_SIZE = 3;
    private List<Integer> computerNumber;

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void initial() {
        setComputerNumber(createComputerNumber());
    }

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < COMPUTER_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

}
