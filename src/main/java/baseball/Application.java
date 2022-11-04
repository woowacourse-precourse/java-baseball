package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(generateRandomNumber());
    }
}
