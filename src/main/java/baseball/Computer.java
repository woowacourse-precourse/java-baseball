package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {

    private ArrayList<Integer> computerBalls;

    public Computer() {
        this.computerBalls = new ArrayList<>();

        while (computerBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.computerBalls.contains(randomNumber)) {
                this.computerBalls.add(randomNumber);
            }
        }
    }

    public ArrayList<Integer> getComputerBalls() {
        return computerBalls;
    }

}
