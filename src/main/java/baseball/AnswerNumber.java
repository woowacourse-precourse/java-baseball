package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerNumber {
    private final int maxNumber = 3;
    private final int rangeStartValue = 1;
    private final int rangeEndValue = 9;
    int[] numArr = new int[maxNumber];

    public int[] getNumberArr() {
        numArr[0] = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);

        numArr[1] = returnNum(numArr[0]);

        numArr[2] = returnNum(numArr[1]);

        return numArr;
    }

    public int returnNum(int num) {
        int tmp = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);

        while (num == tmp){
            tmp = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);
        }

        return tmp;
    }
}
