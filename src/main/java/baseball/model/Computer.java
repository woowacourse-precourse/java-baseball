package baseball.model;

import static baseball.model.Number.LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public enum Computer {

    COMPUTER;

    public List<Integer> number() {
        return generateNumber();
    }

    private static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < LENGTH.getNumber()){
            computer.add(Randoms.pickNumberInRange(1,9));
        }
        return computer;
    }
}
