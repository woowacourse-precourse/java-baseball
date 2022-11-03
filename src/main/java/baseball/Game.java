package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computer;
    private UserInputNumbers userInputValues;

    public Game(UserInputNumbers userInputValues) {
        this.computer = pickThreeNumber();
        this.userInputValues = userInputValues;
    }

    public static List<Integer> pickThreeNumber() {
        List<Integer> threeNumber = new ArrayList<>();
        while (threeNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!threeNumber.contains(randomNumber)) {
                threeNumber.add(randomNumber);
            }
        }
        return threeNumber;
    }
}
