package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Round {
    private static final int NUMBER_OF_HIDDEN_NUMBER = 3;
    private static final int MIN_HIDDEN_NUMBER = 1;
    private static final int MAX_HIDDEN_NUMBER = 9;
    private List<Integer> hiddenNumberList;

    public Round() {
        this.hiddenNumberList = generateNewHiddenNumberList();
    }

    public List<Integer> generateNewHiddenNumberList() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < NUMBER_OF_HIDDEN_NUMBER) {
            addNewHiddenNumberToList(numberList);
        }
        return numberList;
    }

    public void addNewHiddenNumberToList(List<Integer> numberList) {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(MIN_HIDDEN_NUMBER, MAX_HIDDEN_NUMBER);
        } while (numberList.contains(randomNumber));
        numberList.add(randomNumber);
    }
}
