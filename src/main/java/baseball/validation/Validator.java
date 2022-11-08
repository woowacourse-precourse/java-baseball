package baseball.validation;

import java.util.List;

public class Validator {

    private static final Validator instance = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return instance;
    }

    public Boolean isAnyConditionsFalse(String input, List<Condition> conditions) {
        for (Condition condition : conditions) {
            if (!condition.isTrue(input)) {
                return true;
            }
        }

        return false;
    }
}
