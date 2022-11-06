package baseball.domain;

import java.util.List;

public class StrikeModel {

    private final List<Integer> userNumberList;
    private final List<Integer> computerNumberList;

    public StrikeModel(List<Integer> userNumberList, List<Integer> computerNumberList) {
        this.userNumberList = userNumberList;
        this.computerNumberList = computerNumberList;
    }

    // 볼과 스트라이크 int배열로 반환
    public int[] getBallAndStrike() {
        int[] ballAndStrike = new int[2];
        ballAndStrike[1] = getStrike();
        ballAndStrike[0] = getBall() - getStrike();
        return ballAndStrike;
    }

    // 스트라이크 계산
    private int getStrike() {
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            strikeCount += calculateStrike(index);
        }
        return strikeCount;
    }

    // 스트라이크 비교
    private int calculateStrike(int index) {
        if (userNumberList.get(index).equals(computerNumberList.get(index))) {
            return 1;
        }
        return 0;
    }

    // 볼 계산
    private int getBall() {
        int ballCount = 0;
        for (int index = 0; index < 3; index++) {
            ballCount += calculateBall(index);
        }
        return ballCount;
    }

    // 볼 비교
    private int calculateBall(int index) {
        int number = computerNumberList.get(index);
        if (userNumberList.contains(number)) {
            return 1;
        }
        return 0;
    }
}
