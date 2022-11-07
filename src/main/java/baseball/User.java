package baseball;

import java.util.List;

public class User implements Number {
    List<Integer> number;

    @Override
    public void create() {

    }

    @Override
    public List<Integer> get() {

    }

    public static boolean isNumberValidMaxSize(List<Integer> inputNumber) {
        return inputNumber.size() == MAX_SIZE;
    }

    public static boolean isNumberValidRange(List<Integer> inputNumber) {
        return inputNumber.stream().allMatch(number -> number >= START_NUMBER && number <= END_NUMBER);
    }
}
