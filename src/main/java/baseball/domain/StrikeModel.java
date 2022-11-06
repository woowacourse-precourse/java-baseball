package baseball.domain;

import java.util.List;

public class StrikeModel {

    private final int[] userNumber;
    private final int[] computerNumber;

    public StrikeModel(List<Integer> userNumberList, List<Integer> computerNumberList) {
        this.userNumber = getNumberList(userNumberList);
        this.computerNumber = getNumberList(computerNumberList);
    }



    private int[] getNumberList(List<Integer> numberList) {
        int[] numberListArray = new int[3];
        for (int index = 0; index < 3; index++) {
            numberListArray[index] = numberList.get(index);
            System.out.println(numberListArray[index]);
        }
        return numberListArray;
    }
}
