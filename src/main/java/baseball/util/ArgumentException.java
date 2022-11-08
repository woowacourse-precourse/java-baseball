package baseball.util;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class ArgumentException {
    public static void isException(boolean compare, ArgumentExceptionMessage inputUnconformableLength) {
        if (compare) {
            throw new IllegalArgumentException(inputUnconformableLength.getMessage());   // 입력받은 값의 길이가 요구사항과 다른 경우
        }
    }
}
