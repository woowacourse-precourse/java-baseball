package baseball.domain;

import java.util.List;

public class StrikeModel {

    private final int[] userNumber;
    private final int[] computerNumber;

    public StrikeModel(List<Integer> userNumberList, List<Integer> computerNumberList) {
        this.userNumber = getNumberList(userNumberList);
        this.computerNumber = getNumberList(computerNumberList);
    }

    // 볼과 스트라이크 int배열로 반환
    public int[] getBallAndStrike() {

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
        if (userNumber[index] == computerNumber[index]) {
            return 1;
        }
        return 0;
    }

    // 볼 계산
    private int getBall() {
        int ballCount = 0;
        for (int index = 0; index < 3; index++) {
        }
        return ballCount;
    }

    // List를 int배열로 변환
    private int[] getNumberList(List<Integer> numberList) {
        int[] numberListArray = new int[3];
        for (int index = 0; index < 3; index++) {
            numberListArray[index] = numberList.get(index);
            System.out.println(numberListArray[index]);
        }
        return numberListArray;
    }
}
