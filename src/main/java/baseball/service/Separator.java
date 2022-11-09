package baseball.service;

import baseball.entity.Condition;
import baseball.entity.Type;
import baseball.mapper.StringMapper;

import java.util.HashMap;
import java.util.Map;

public class Separator {

    private Condition condition;

    public Separator(String input) {
        this.condition = new Condition(input);
    }

    public Map<Type, Integer> separateInputResult(String input) {
        Map<Type, Integer> map = new HashMap<>();
        map.put(Type.BALL, 0);
        map.put(Type.STRIKE, 0);
        map.put(Type.NOTHING, 0);

        for (int digit = 0; digit < input.length(); digit++) {
            String partOfNum = StringMapper.ctos(input.charAt(digit));
            Type result = checkCurrentCondition(partOfNum, digit);
            map.put(result, map.get(result) + 1);
        }

        return map;
    }

    private Type checkCurrentCondition(String partOfNum, int digit) {
        boolean containCheck = condition.doesContain(partOfNum);
        boolean digitCheck = condition.isDigitCorrect(partOfNum, digit);

        if (containCheck && digitCheck) {
            return Type.STRIKE;
        }
        if (containCheck && !digitCheck) {
            return Type.BALL;
        }
        return Type.NOTHING;
    }

    public Type forTest_checkCurrentCondition(String partOfNum, int digit) {
        return checkCurrentCondition(partOfNum, digit);
    }
}
