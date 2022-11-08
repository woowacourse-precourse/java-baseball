package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private final List<BallNumber> gameNumberSet;

    public ComputerNumber(List<BallNumber> gameNumberSet) {
        this.gameNumberSet = gameNumberSet;
    }

    public static List<BallNumber> generateRandomNumberSet() {
        List<BallNumber> numberSet = new ArrayList<>();
        while (numberSet.size() < MessageUtils.BALL_SET_SIZE) {
            BallNumber randomNumber = new BallNumber(Randoms.pickNumberInRange(MessageUtils.MIN_NUMBER, MessageUtils.MAX_NUMBER));
            if (!numberSet.contains(randomNumber)) {
                numberSet.add(randomNumber);
            }
        }
        return numberSet;
    }

    public List<BallNumber> getGameNumberSet() {
        return gameNumberSet;
    }
}
