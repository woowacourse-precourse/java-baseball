package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer{

    private ArrayList<Integer> computerBalls;

    public Computer() {
        ArrayList<Integer> computerBalls = new ArrayList<>();

        while (computerBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBalls.contains(randomNumber)) {
                computerBalls.add(randomNumber);
            }
        }
    }

    public ArrayList<Integer> getComputerBalls() {
        return computerBalls;
    }


}
