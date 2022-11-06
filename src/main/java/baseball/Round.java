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
        this.hiddenNumberList = new ArrayList<>();
    }

    public Round(List<Integer> testHiddenNumberList) {
        this.hiddenNumberList = testHiddenNumberList;
    }

    public void start() {
        if (hiddenNumberList.isEmpty()) {
            this.hiddenNumberList = generateNewHiddenNumberList();
        }
        Turn turn;
        do {
            turn = new Turn();
            turn.start(this.hiddenNumberList);
        } while (!turn.isStrikeOut());
        turn.printGameOverMessage();
    }

    public List<Integer> generateNewHiddenNumberList() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < NUMBER_OF_HIDDEN_NUMBER) {
            addNewRandomNumberToList(numberList);
        }
        return numberList;
    }

    public void addNewRandomNumberToList(List<Integer> numberList) {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(MIN_HIDDEN_NUMBER, MAX_HIDDEN_NUMBER);
        } while (numberList.contains(randomNumber));
        numberList.add(randomNumber);
    }
}
