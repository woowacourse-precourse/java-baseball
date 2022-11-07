package baseball;

import java.util.List;

public class Rule {

    private List<Integer> selectedNumbers;
    private int strikeCount;
    private int ballCount;

    public void selectedNumber(List<Integer> computerNumbers) {
        this.selectedNumbers = computerNumbers;
    }

    public ResponseView answerNumber(List<Integer> target) {
        for (int index = 0; index < target.size(); index++) {
            Integer value = target.get(index);
            contains(index, value);
        }

        ResponseView gameMessage = new ResponseView(strikeCount, ballCount);
        clear();
        return gameMessage;
    }

    private void clear() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private void contains(int index, Integer value) {
        if (containsExactly(value, index)) {
            strikeCount += 1;
            return;
        }

        if (contains(value)) {
            ballCount += 1;
        }
    }

    private boolean containsExactly(Integer value, int index) {
        return selectedNumbers.contains(value) && selectedNumbers.get(index).equals(value);
    }

    private boolean contains(Integer value) {
        return selectedNumbers.contains(value);
    }
}
