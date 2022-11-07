package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Service {

    public int findBall(int score, int input) {
        int count = 0;
        if (Objects.equals(score / 100, input / 10 % 10) || Objects.equals(score / 100, input % 10)) count++;
        if (Objects.equals(score / 10 % 10, input / 100) || Objects.equals(score / 10 % 10, input % 10)) count++;
        if (Objects.equals(score % 10, input / 100) || Objects.equals(score % 10, input / 10 % 10)) count++;
        return count;
    }

    public int findStrike(int score, int input) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(score % 10, input % 10)) count++;
            score /= 10;
            input /= 10;
        }
        return count;
    }

    public int generateScore() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.get(0) * 100 + computer.get(1) * 10 + computer.get(2);
    }
}
