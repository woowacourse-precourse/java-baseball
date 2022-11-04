package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public int findBall(int score, int input) {
        int count = 0;
        if (score / 100 == input / 10 % 10 || score / 100 == input % 10) count++;
        if (score / 10 % 10 == input / 100 || score / 10 % 10 == input % 10) count++;
        if (score % 10 == input / 100 || score % 10 == input / 10 % 10) count++;
        return count;
    }

    public int findStrike(int score, int input) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (score % 10 == input % 10) count++;
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
