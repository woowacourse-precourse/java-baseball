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
            strikeCount += equalNumber(index);
        }
        return strikeCount;
    }

    // 스트라이크
    private int equalNumber(int index) {
        if (userNumber[index] == computerNumber[index]) {
            return 1;
        }
        return 0;
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
