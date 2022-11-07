package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static int[] randomNumber = new int[3];
    public static void start() {
        generateThreeDigitNumber();

    }
    public static void generateThreeDigitNumber() {
        randomNumber[0] = Randoms.pickNumberInRange(1, 9);
        randomNumber[1] = Randoms.pickNumberInRange(0, 9);
        randomNumber[2] = Randoms.pickNumberInRange(0, 9);
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        start();

    }
}
