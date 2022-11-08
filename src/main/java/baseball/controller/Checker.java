package baseball.controller;

import baseball.model.Baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checker {
    private static final int ANSWER_COUNT = 3;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final int ZERO = 0;
    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private Map<String, Integer> result;
    private Baseball computer;

    public Map<String, Integer> start(Baseball computer, Baseball user) {
        this.computer = computer;
        result = compare(user);
        return result;
    }
    public Map<String, Integer> compare(Baseball userNumber) {
        HashMap<String, Integer> result = new HashMap<>();
        for(int i = 0; i < userNumber.size(); i++) {
            if(isStrike(i, userNumber)) {
                result.put(STRIKE, result.getOrDefault(STRIKE, 0)+ 1);
                continue;
            }
            if(isBall(i,userNumber)) {
                result.put(BALL, result.getOrDefault(BALL, 0)+ 1);
            }
        }
        return result;
    }

    public boolean isStrike(int index, Baseball user) {
        if(computer.hasNumber(index, user.getNumber(index))) {
            return true;
        }
        return false;
    }
    public boolean isBall(int index, Baseball user) {
        List<Integer> computerBaseballNumber = computer.getBaseballNumber();
        if(computerBaseballNumber.contains(user.getNumber(index))) {
            return true;
        }
        return false;
    }
}
