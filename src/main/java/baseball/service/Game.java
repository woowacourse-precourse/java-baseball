package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static baseball.model.Constants.*;

public class Game {
    public final List<Integer> computerNum;

    public Game() {
        this.computerNum = generate();
    }

    public List<Integer> generate() {
        List<Integer> nums = new ArrayList<>();
        while (nums.size() != INPUT_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            addNotDuplicateNumbers(nums, randomNum);
        }
        return nums;
    }

    public void addNotDuplicateNumbers(List<Integer> nums, int randomNum) {
        if (!nums.contains(randomNum)) {
            nums.add(randomNum);
        }
    }

    public int getStrikeCount(List<Integer> userNum) {
        return (int) Stream.iterate(0, i -> i < INPUT_LENGTH, i -> i + 1)
                .filter(i -> userNum.get(i) == computerNum.get(i))
                .count();
    }

    public int getBallCount(List<Integer> userNum) {
        return (int) Stream.iterate(0, i -> i < INPUT_LENGTH, i -> i + 1)
                .filter(i -> computerNum.contains(userNum.get(i)) && userNum.get(i) != computerNum.get(i))
                .count();
    }

    public boolean isClear(int strikeCount) {
        return strikeCount == MAX_STRIKE;
    }
}

