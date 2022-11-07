package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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

    public static void isNumberValidRange(List<Integer> inputNumber) {
        inputNumber.forEach(number -> {
            if (number < START_NUMBER || number > END_NUMBER) throw new IllegalArgumentException();
        });
    }
}
