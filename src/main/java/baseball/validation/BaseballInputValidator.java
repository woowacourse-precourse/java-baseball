package baseball.validation;

import java.util.List;

public class BaseballInputValidator implements Validator<List<Integer>> {

    private static final int SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    @Override
    public boolean validate(final List<Integer> target) {
        return validateSize(target) && validateRange(target, MIN, MAX) && validateDup(target);
    }

    private boolean validateSize(final List<Integer> target) {
        return target.size() == SIZE;
    }

    private boolean validateRange(final List<Integer> target,
        final int startInclusive,
        final int endInclusive) {
        for (Integer num : target) {
            if (num < startInclusive || num > endInclusive) {
                return false;
            }
        }
        return true;
    }

    private boolean validateDup(final List<Integer> target) {
        for (int i = 0; i < target.size(); i++) {
            int cur = target.get(i);
            if (isDup(target, cur, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDup(final List<Integer> target, final int cur,
        final int curIdx) {
        for (int i = 0; i < target.size(); i++) {
            if (curIdx == i) {
                continue;
            }
            if (target.get(i).equals(cur)) {
                return true;
            }
        }
        return false;
    }
}
