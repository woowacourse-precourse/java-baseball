package baseball;


import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

/**
 * 정답값과 입력값 문자열 비교
 * 1. 포함여부
 * 2. 순서 확인
 */
class Array {
    static boolean isArrayContains(final int[] ar, final int num) {
        for (int value : ar) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    static int inputIndexValue(final int[] ar, final int value) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

class Game {

    int[] number = new int[3];

    Game() {
        int randomNum;
        int numberIndex = 0;

        while (numberIndex < 3) {
            randomNum = Randoms.pickNumberInRange(1, 9);

            if (!Array.isArrayContains(number, randomNum)) {
                number[numberIndex++] = randomNum;
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < 3; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }
}