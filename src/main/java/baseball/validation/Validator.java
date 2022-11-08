package baseball.validation;

import java.util.List;

public class Validator {

    private static final Validator instance = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return instance;
    }

    /**
     * @param input:      user Input
     * @param conditions: conditions for validating input
     * @return if (all conditions are true: -1) else (index of condition which is false)
     */
    public Integer getNotPassConditionIndex(String input, List<Condition> conditions) {
        for (int index = 0; index < conditions.size(); index++) {
            Condition condition = conditions.get(index);

            if (!condition.isTrue(input)) {
                return index;
            }
        }

        return -1;
    }
}
