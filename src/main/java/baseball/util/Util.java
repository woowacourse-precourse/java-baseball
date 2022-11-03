package baseball.util;

import java.util.Arrays;

public class Util {
    public static boolean isDuplicated(int[]numbers){
        long count = Arrays.stream(numbers).distinct().count();
        return numbers.length ==  count;
    }
}
