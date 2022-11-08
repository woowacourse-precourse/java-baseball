package baseball.domain;

import java.util.List;

public class StrikeModel {

    private static final int NUMBER_LIST_SIZE = 3;
    private final List<Integer> userNumberList;
    private final List<Integer> computerNumberList;

    public StrikeModel(List<Integer> userNumberList, List<Integer> computerNumberList) {
        this.userNumberList = userNumberList;
        this.computerNumberList = computerNumberList;
    }

    // 스트라이크 갯수 반환
    public int getStrike() {
        int strikeCount = 0;
        for (int index = 0; index < NUMBER_LIST_SIZE; index++) {
            strikeCount += calculateStrike(index);
        }
        return strikeCount;
    }

    // 스트라이크 계산 기능
    private int calculateStrike(int index) {
        if (userNumberList.get(index).equals(computerNumberList.get(index))) {
            return 1;
        }
        return 0;
    }

    // 볼 갯수 반환
    public int getBall() {
        int ballCount = 0;
        for (int index = 0; index < NUMBER_LIST_SIZE; index++) {
            ballCount += calculateBall(index);
        }
        return ballCount - getStrike();
    }

    // 볼 계산 기능
    private int calculateBall(int index) {
        int number = computerNumberList.get(index);
        if (userNumberList.contains(number)) {
            return 1;
        }
        return 0;
    }
}
