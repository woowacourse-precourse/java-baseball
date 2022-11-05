package baseball.condition.systeminput;

import baseball.condition.Condition;

import java.util.List;

public class isOperationCodeCond implements Condition {

    private static final List<Integer> OPERATION_CODE = List.of(1, 2);

    @Override
    public Boolean hasFulfilled(Integer input) {
        return OPERATION_CODE.contains(input);
    }
}
