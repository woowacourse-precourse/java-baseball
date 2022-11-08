package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameUtil {
    public static List<Integer> stringToIntList(String str) { //type Class
        List<Integer> list;
        list = Arrays.stream(str.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return list;
    }
}
