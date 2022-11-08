package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerBaseball {
    private List<Integer> numberList = new ArrayList<>();

    public ComputerBaseball() {
        initNumbers();
    }

    private void initNumbers() {
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
    }
    public List<Integer> getNumberList() {
        return numberList;
    }

    public void resetNumberList() {
        numberList.clear();
        initNumbers();
    }

}
