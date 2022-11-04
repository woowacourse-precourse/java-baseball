package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


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

    public static boolean isInput(String value) {

        if(value.length() != 3){ // 3자리 글자인지 확인
            throw new IllegalArgumentException();
        }

        for(int i=0; i<3; i++){ // 숫자만 넣었는지 확인
            if(!Character.isDigit(value.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

        if(!dupliccatCheck(value)){ // 중복 값 확인
            throw new IllegalArgumentException();
        }
        return false;
    }

    public static boolean dupliccatCheck(String str) {
        int a = (int)str.charAt(0);
        int b = (int)str.charAt(1);
        int c = (int)str.charAt(2);

        if(a != b && a != c && b != c) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        // 랜덤으로 숫자 세개 생성
        AnswerNumber answerNumber = new AnswerNumber();
        int[] answer = new int[3];
        answer = answerNumber.getNumberArr();

        // 사용자 입력 받기
        String inputValue = Console.readLine();
        try {
            isInput(inputValue);
        } catch (IllegalArgumentException e) {
            return;
        }

    }
}
