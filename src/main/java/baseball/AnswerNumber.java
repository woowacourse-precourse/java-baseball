package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerNumber {
    private final int maxNumber = 3;
    private final int rangeStartValue = 1;
    private final int rangeEndValue = 9;
    int[] numArr = new int[maxNumber];

    public int[] getNumberArr() {
        numArr[0] = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);

        numArr[1] = returnSndNum(numArr[0]);

        numArr[2] = returnTrdNum(numArr[0], numArr[1]);

        return numArr;
    }

    public int returnSndNum(int num) {
        int tmp = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);

        while (num == tmp){
            tmp = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);
        }

        return tmp;
    }

    public int returnTrdNum(int firNum, int sndNum){
        int tmp = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);

        while (firNum == tmp || sndNum == tmp ){
            tmp = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);
        }

        return tmp;
    }
}
