package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private List<Integer> computerNumber = new ArrayList<>();

    public void start() {}

    private List<Integer> setComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public List<Integer> getComputerNumber() {
        if (computerNumber.isEmpty()) {
            computerNumber = setComputerNumber();
        }
        return computerNumber;
    }

    public void printUserInputPrompt() {
        System.out.println("숫자를 입력해주세요 : ");
    }
}
