package baseball.game;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public List<Integer> compareLists(List<Character> users, List<Character> computers) {
        List<Integer> strikeBall = new ArrayList<>();
        strikeBall.add(0, checkIndexStrike(users, computers));
        strikeBall.add(1, checkIndexBall(users, computers));
        return strikeBall;
    }

    private int checkIndexStrike(List<Character> user, List<Character> computers) {
        int strike = 0;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i) == computers.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int checkIndexBall(List<Character> user, List<Character> computers) {
        int ball = 0;
        for (int i = 0; i < user.size(); i++) {
            char userNum = user.get(i);
            if (computers.contains(userNum) && i != computers.indexOf(userNum)) {
                ball++;
            }
        }
        return ball;
    }
}