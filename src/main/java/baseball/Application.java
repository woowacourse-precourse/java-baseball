package baseball;

import camp.nextstep.edu.missionutils.Randoms;



public class Application {

    public static class AnswerNumber {
        private final int maxNumber = 3;
        private final int rangeStartValue = 1;
        private final int rangeEndValue = 9;
        int[] numArr = new int[maxNumber];

        public int[] getNumberArr() {
            for (int i = 0; i<maxNumber; i++) {
                numArr[i] = Randoms.pickNumberInRange(rangeStartValue, rangeEndValue);
            }
            return numArr;
        }
    }

    public static void main(String[] args) {
        // 랜덤으로 숫자 세개 생성
        AnswerNumber answerNumber = new AnswerNumber();

        int[] answer = new int[3];
        answer = answerNumber.getNumberArr();


    }
}
