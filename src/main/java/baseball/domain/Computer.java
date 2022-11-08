package baseball.domain;

import baseball.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {

    private List<Integer> randomNumbers;

    public Computer() {
        this.randomNumbers = new ArrayList<>();
    }

    public Computer(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public void pickRandomNumbers() {
        this.randomNumbers = RandomUtils.pickThreeRandomNumbers();
    }

    public Map<String, Integer> countBallAndStrikeWithPlayer(Player player, Map<String, Integer> result) {
        return player.countBallAndStrikeWithComputer(randomNumbers, result);
    }
}
