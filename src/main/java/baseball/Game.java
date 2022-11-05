package baseball;

import java.util.LinkedList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private static final int RANDOM_START_RANGE = 1;
    private static final int RANDOM_END_RANGE = 9;
    static final int MAX_NUMBER_COUNT = 3;
    static LinkedList<Integer> answer;

    Game() {
        answer = new LinkedList<>();
        answer = setComputerNumber();
    }

    public LinkedList<Integer> setComputerNumber() {
        int RandomNumber;
        LinkedList<Integer> result = new LinkedList<>();
        while (result.size() < MAX_NUMBER_COUNT) {
            RandomNumber = this.getRandomNumber();
            if (!result.contains(RandomNumber)) {
                result.add(RandomNumber);
            }
        }
        return result;
    }

    private int getRandomNumber() {
        return pickNumberInRange(Game.RANDOM_START_RANGE, Game.RANDOM_END_RANGE);
    }
}
