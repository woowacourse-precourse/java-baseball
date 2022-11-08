package baseball.inputException;

import java.util.List;

public class ContainingZeroException extends IllegalArgumentException{

    public ContainingZeroException() {
        super("number can not contain zero.");
    }

    public static boolean isContainingZero(List<Integer> number) {
        return (number.contains(0));
    }
}
