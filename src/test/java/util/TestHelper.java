package util;

import baseball.MatchCode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestHelper {
    public static int[] stringToArray(String input){
        return Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static List<Integer> stringToList(String input) {
        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static Map<String, Integer> createMapForTest(int ball, int strike){
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put(MatchCode.BALL.toString(), ball);
        result.put(MatchCode.STRIKE.toString(), strike);
        return result;
    }
}
