package baseball;

import java.util.List;

public class Computer {
    public List<Integer> getRandomNumbers() {
        RandomNumbersMaker randomNumbersMaker = new RandomNumbersMaker();

        return randomNumbersMaker.makeRandomNumbers();
    }
}
