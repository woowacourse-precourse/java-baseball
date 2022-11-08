package baseball.inputException;

import java.util.List;

public class DuplicatedNumberException extends IllegalArgumentException{

    public DuplicatedNumberException() {
        super("number can not have duplicated digit.");
    }

    public static boolean confirmDuplicationNumber(List<Integer> number) {
        return (number.get(0) != number.get(1)) && (number.get(1) != number.get(2)) && (number.get(0) != number.get(2));
    }
}
