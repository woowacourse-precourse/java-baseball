package baseball.domain;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Hint hint = new Hint();
    private List<Integer> randomNumbers = new ArrayList<>();

    public List<Integer> makeRandomNumbers() {
        initializeRandomNumbers();
        return randomNumbers;
    }

    private void initializeRandomNumbers() {
        randomNumbers.clear();
        while (randomNumbers.size() < Constant.SIZE_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    public String resultOfGame(List<Integer> playerInputs, List<Integer> randomNumbers) {
        return hint.calculateResult(playerInputs, randomNumbers);
    }

    public boolean isAnswer() {
        return hint.isThreeStrike();
    }
}
