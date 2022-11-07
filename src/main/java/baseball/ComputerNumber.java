package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int GAME_NUMBER_SET_SIZE = 3;
    private final List<BallNumber> gameNumberSet;

    public ComputerNumber(List<BallNumber> gameNumberSet) {
        this.gameNumberSet = gameNumberSet;
    }

    public static List<BallNumber> generateRandomNumberSet() {
        List<BallNumber> numberSet = new ArrayList<>();
        while (numberSet.size() < GAME_NUMBER_SET_SIZE) {
            BallNumber randomNumber = new BallNumber(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
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
