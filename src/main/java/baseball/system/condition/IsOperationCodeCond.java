package baseball.system.condition;

import baseball.validation.Condition;

import java.util.List;

public class IsOperationCodeCond implements Condition {

    private static final Condition instance = new IsOperationCodeCond();
    private static final List<String> OPERATION_CODE = List.of("1", "2");

    private IsOperationCodeCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isTrue(Integer input) {
        return OPERATION_CODE.contains(Integer.toString(input));
    }
}
