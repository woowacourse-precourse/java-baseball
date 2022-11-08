package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class ComputerNumber {

    private List<Integer> randomBallNumber;

    public ComputerNumber() {
        randomBallNumber = new ArrayList<>();
    }

    public List<Integer> getComputerNumber() {
        return randomBallNumber;
    }

    public void makeRandomNumber() {
        HashSet<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() < Constants.NUMBER_LENGTH) {
            int number = Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
            randomNumbers.add(number);
        }
        randomBallNumber = new ArrayList<>(randomNumbers);
    }
}