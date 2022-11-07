package baseball.repository;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    int score;

    public int getScore() {
        return score;
    }
    public Repository(){
        this.score = generateScore();
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
