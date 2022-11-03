package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Round {
    private static final int NUMBER_OF_HIDDEN_NUMBER = 3;
    private static final int MIN_HIDDEN_NUMBER = 9;
    private static final int MAX_HIDDEN_NUMBER = 9;
    private List<Integer> hiddenNumberList;

    public Round() {
        //this.hiddenNumberList = generateNewHiddenNumberList();
    }

    public void addNewHiddenNumberToList(List<Integer> numberList) {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        } while (numberList.contains(randomNumber));
        numberList.add(randomNumber);
    }
}
