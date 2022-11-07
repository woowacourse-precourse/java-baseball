package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.GameConstants.*;

public class ComputerNumber {
    private List<Integer> computerNumber;

    public ComputerNumber() {
        computerNumber = new ArrayList<>();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void makeComputerNumber() {
        HashSet<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < NUMBER_LENGTH) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            randomNumbers.add(number);
        }
        computerNumber = new ArrayList<>(randomNumbers);
    }
}