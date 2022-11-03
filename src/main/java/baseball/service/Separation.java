package baseball.service;

import baseball.mapper.StringMapper;

import java.util.HashMap;
import java.util.Map;

public class Separation {

    private NumberCondition condition;

    public Separation(String input) {
        this.condition = new NumberCondition(input);
    }

    Map<String, Integer> separateInputResult(String input) {
        Map<String, Integer> map = new HashMap<>();
        map.put("ball",0);
        map.put("strike",0);
        map.put("nothing",0);

        for(int digit=0 ; digit<input.length() ; digit++) {
            String partOfNum = StringMapper.ctos(input.charAt(digit));
            String result = checkCurrentCondition(partOfNum, digit);
            map.put(result, map.get(result)+1);
        }

        return map;
    }

    private String checkCurrentCondition(String partOfNum, int digit) {
        boolean containCheck = condition.doesContain(partOfNum);
        boolean digitCheck = condition.isDigitCorrect(partOfNum,digit);

        if(containCheck && digitCheck) {
            return "strike";
        }
        if(containCheck && !digitCheck) {
            return "ball";
        }
        return "nothing";
    }

    public String copyCheckCurrentConditionForTest(String partOfNum, int digit) {
        return checkCurrentCondition(partOfNum, digit);
    }
}
