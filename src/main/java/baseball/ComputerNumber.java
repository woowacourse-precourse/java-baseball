package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

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
        while (randomNumbers.size() < GameConstants.NUMBER_LENGTH) {
            int number = Randoms.pickNumberInRange(GameConstants.MIN_NUMBER, GameConstants.MAX_NUMBER);
            randomNumbers.add(number);
        }
        computerNumber = new ArrayList<>(randomNumbers);
    }
}