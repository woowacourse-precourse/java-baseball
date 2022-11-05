package baseball;

import java.util.Map;

public class Judge {

    private static class JudgeHolder {
        private static final Judge INSTANCE = new Judge();
    }

    private Judge() {

    }

    public static Judge getInstance() {
        return JudgeHolder.INSTANCE;
    }

    public Result compare(Map<Integer, Integer> computerNumber, Map<Integer, Integer> userNumber) {
        Result result = new Result();

        for (int current : userNumber.keySet()) {
            if (!isBallOrStrike(computerNumber, current)) {
                continue;
            }

            if (isStrike(computerNumber, userNumber, current)) {
                result.add(ResultType.STRIKE);
                continue;
            }

            result.add(ResultType.BALL);
        }

        if (isNothing(result)) {
            result.add(ResultType.NOTHING);
        }

        return result;
    }

    private boolean isBallOrStrike(Map<Integer, Integer> computerNumber, int current) {
        return computerNumber.containsKey(current);
    }

    private boolean isStrike(Map<Integer, Integer> computerNumber, Map<Integer, Integer> userNumber,
            int current) {
        int computerIndex = computerNumber.get(current);
        int userIndex = userNumber.get(current);
        return computerIndex == userIndex;
    }

    private boolean isNothing(Result result) {
        return (result.get(ResultType.BALL) == 0) && (result.get(ResultType.STRIKE) == 0);
    }

}
