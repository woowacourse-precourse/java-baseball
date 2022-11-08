package baseball.model;

import baseball.constant.Config;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private List<Integer> computerNumbers;

    public Computer() {
        computerNumbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return computerNumbers;
    }

    public void setNumbers() {
        Set<Integer> deduplicateNumbers = new HashSet<>();

        while (deduplicateNumbers.size() < Config.DIGIT_SIZE) {
            int computerNumber = Randoms.pickNumberInRange(Config.DIGIT_MIN, Config.DIGIT_MAX);
            deduplicateNumbers.add(computerNumber);
        }

        this.computerNumbers = new ArrayList<>(deduplicateNumbers);
    }
}
