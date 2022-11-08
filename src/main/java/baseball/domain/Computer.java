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

    public String printResult(List<Integer> strikeBallList) {
        return strikeBallList.get(0) + "볼 " + strikeBallList.get(1) + "스트라이크";
    }

    public List<Integer> getBallStrikeList(int sameNumbersCnt, int numberOfDigitCnt) {
        int strike = numberOfDigitCnt;
        int ball = sameNumbersCnt - strike;
        return new ArrayList<>(List.of(ball, strike));
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
