package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {
    private List<Integer> ballNumber;

    public List<Integer> getBallNumber() {
        return ballNumber;
    }

    public void throwTheBall() {
        Set<Integer> randomNumbers = new HashSet<>();

        while(randomNumbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!randomNumbers.contains(num)) {
                randomNumbers.add(num);
            }
        }

        ballNumber = randomNumbers.stream().collect(Collectors.toList());
    }
}
