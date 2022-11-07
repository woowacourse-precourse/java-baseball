package baseball;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/07
 */
public class ArgumentExcpetion {
    public static void isException(boolean contains, ArgumentExceptionMessage argumentExceptionMessage) {
        if (contains) {
            throw new IllegalArgumentException(argumentExceptionMessage.getMessage());
        }
    }
}
