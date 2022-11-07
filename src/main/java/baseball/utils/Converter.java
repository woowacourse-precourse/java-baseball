package baseball.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {
    public static List<Integer> toIntegerList(String string) {
        List<String> stringList = List.of(string.split(""));
        return stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String changeResultMapToString(Map<String, Integer> resultMap) {
        String BALL = ScoreType.BALL.getValue();
        String STRIKE = ScoreType.STRIKE.getValue();
        Integer ballCount = resultMap.get(ScoreType.BALL.getLabel());
        Integer strikeCount = resultMap.get(ScoreType.STRIKE.getLabel());
        List<String> resultList = new ArrayList<>();

        if (ballCount > 0) {
            resultList.add(ballCount + BALL);
        }

        if (strikeCount > 0) {
            resultList.add(strikeCount + STRIKE);
        }

        if (resultList.size() == 0) {
            return ScoreType.NOTHING.getValue();
        }

        return String.join(" ", resultList);
    }
}
