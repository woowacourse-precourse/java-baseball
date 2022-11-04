package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> computer = new ArrayList<>();

    public Game() {

    }

    public List<Integer> getComputer() {
        generateNum();
        return computer;
    }

    private void generateNum() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNum(computer, randomNumber);
        }
    }

    private void addNum(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    private void checkInput(List<Integer> user)
    {
        BallCount ballcounter = new BallCount();

        for (int idx = 0; idx < 3; idx++){
            checkStrikeOrBall(user, ballcounter, idx);
        }
    }

    private void checkStrikeOrBall(List<Integer> user, BallCount ballcounter, int idx) {
        if (user.get(idx).equals(computer.get(idx))) {
            ballcounter.plusStrike();
        } else if (computer.contains(user.get(idx))) {
            ballcounter.plusBall();
        }
    }
}
