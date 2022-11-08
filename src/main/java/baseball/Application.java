package baseball;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

/**
 * 정답값과 입력값 문자열 비교
 * 1. 포함여부
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
}
