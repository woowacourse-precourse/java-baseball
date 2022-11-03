package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import baseball.utils.Converter;

public class Game {
    private List<Integer> answer = new ArrayList<>();

    public Game(List<Integer> randomNumberList) {
        this.answer = randomNumberList;
    }

    public Map<String, Integer> getResult(String userAnswer) {
        Map<String,Integer> resultMap = new HashMap<>() {{
            put("ball", 0);
            put("strike", 0);
        }};

        List<Integer> answerIntegerList = Converter.toIntegerList(userAnswer);
        for (int index = 0; index < answerIntegerList.size(); index++) {
            Integer currentInteger = answerIntegerList.get(index);
            if (Objects.equals(answer.get(index), currentInteger)) {
                resultMap.put("strike",resultMap.get("strike") + 1);
                continue;
            }

            if (answer.contains(answerIntegerList.get(index))) {
                resultMap.put("ball",resultMap.get("ball") + 1);
            }
        }
        return resultMap;
    }
}
