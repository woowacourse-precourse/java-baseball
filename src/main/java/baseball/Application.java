package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int createTensDifferentFrom(int hundreds) {
        while (true) {
            int tens = Randoms.pickNumberInRange(1, 9);
            if (hundreds != tens)
                return tens;
        }
    }

    public static int createOnesDifferentFrom(int hundreds, int tens) {
        while (true) {
            int ones = Randoms.pickNumberInRange(1, 9);
            if (hundreds != ones && tens != ones)
                return ones;
        }
    }
}