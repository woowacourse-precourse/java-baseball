package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Baseball {
    private List<Integer> computerRandom = new ArrayList<>();
    private List<Integer> playerNumber = new ArrayList<>();
    private List<Integer> baseballCount = new ArrayList<>();

    public void pickRandomNumber() {
        while (computerRandom.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandom.contains(randomNumber)) {
                computerRandom.add(randomNumber);
            }
        }
    }
}