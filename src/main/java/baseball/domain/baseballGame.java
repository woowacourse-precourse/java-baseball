package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class baseballGame {
    private List<Integer> computer;
    private Set<Integer> randomNumberSet;
    private int strikeCount;
    private int ballCount;
    private int restart;

    public baseballGame() {
        computer = new ArrayList<>();
        strikeCount = 0;
        ballCount = 0;
        restart = 0;
    }

    public void createRandomNumber() {
        int randomNumber;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumber(randomNumber);
        }
        randomNumberSet = new HashSet<>(computer);
    }

    private void addNumber(int number) {
        if (!computer.contains(number)) {
            computer.add(number);
        }
    }

    public void initCounts() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void checkMatch(String inputNumber) {
        for (int i = 0; i < 3; i++) {
            countStrikeAndBall(inputNumber, i);
        }
    }

}
