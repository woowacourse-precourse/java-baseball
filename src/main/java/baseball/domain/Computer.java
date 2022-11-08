package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private void continueOrQuit() {
    }

    public List<Integer> selectNumbers() {
        List<Integer> selectNumberList = new ArrayList<>();
        Ball ball = new Ball();

        while (selectNumberList.size() < 3) {
            int randomNumber = ball.getRandomNumber();
            if (selectNumberList.contains(randomNumber)) continue;
            selectNumberList.add(randomNumber);
        }

        return selectNumberList;
    }

    private String printResult() {
        return "";
    }

    private List<Integer> compareNumbers() {
        return new ArrayList<>();
    }

    public int checkSameNumbersCount(List<Integer> computerList, List<Integer> playerList) {
        int sameNumbersCnt = 0;

        for (Integer number : computerList) {
            if (playerList.contains(number)) sameNumbersCnt++;
        }

        return sameNumbersCnt;
    }

    public int checkSameNumberOfDigit(List<Integer> computerList, List<Integer> playerList) {
        int numberOfDigitCnt = 0;

        for (int idx = 0; idx < 3; idx++) {
            if (computerList.get(idx) == playerList.get(idx)) numberOfDigitCnt++;
        }

        return numberOfDigitCnt;
    }
}
