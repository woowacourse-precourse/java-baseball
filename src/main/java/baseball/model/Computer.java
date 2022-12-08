package baseball.model;

import baseball.utils.Constant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computerNumbers;

    public Computer() {
        this.computerNumbers = setComputerNumbers();
    }

    public List<Integer> getComputerNumbers() {
        return this.computerNumbers;
    }

    private List<Integer> setComputerNumbers() {
        List<Integer> newComputerNumber = new ArrayList<>();
        while (newComputerNumber.size() < Constant.GAME_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constant.MIN_GAME_RANGE, Constant.MAX_GAME_RANGE);
            if (!newComputerNumber.contains(randomNumber)) {
                newComputerNumber.add(randomNumber);
            }
        }
        return newComputerNumber;
    }
}
