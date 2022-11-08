package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private void continueOrQuit() {
    }

    public List<Integer> selectNumbers() {
        ArrayList<Integer> selectNumberList = new ArrayList<>();
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

    private int checkSameNumbersCount() {
        return 0;
    }

    private boolean checkSameNumberOfDigit() {
        return true;
    }
}
