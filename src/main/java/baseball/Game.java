package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private List<Integer> computerNumber = new ArrayList<>();

    public void start() {}

    public void setComputerNumber() {
        List<Integer> newComputerNumber = new ArrayList<>();
        while (newComputerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!newComputerNumber.contains(randomNumber)) {
                newComputerNumber.add(randomNumber);
            }
        }
        computerNumber = newComputerNumber;
    }

    public List<Integer> getComputerNumber() {
        if (computerNumber.isEmpty()) {
            setComputerNumber();
        }
        return computerNumber;
    }

    public void printUserInputPrompt() {
        System.out.println("숫자를 입력해주세요 : ");
    }
}
