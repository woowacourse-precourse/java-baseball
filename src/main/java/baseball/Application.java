package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static int[] generateThreeDigitNumber() {
        int[] threeDigitNum = new int[3];
        threeDigitNum[0] = Randoms.pickNumberInRange(1, 9);
        threeDigitNum[1] = Randoms.pickNumberInRange(0, 9);
        threeDigitNum[2] = Randoms.pickNumberInRange(0, 9);
        return threeDigitNum;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");

        int[] randomNumber = generateThreeDigitNumber();
    }
}
