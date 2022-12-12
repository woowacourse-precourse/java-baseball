package baseball.model;

import baseball.dto.Hints;
import baseball.util.Rules;

import java.util.List;

public enum Success {
    SUCCESS,
    FAIL;

    public static Success getSuccess(Hints hints) {
        if (hints.getScore(Hint.STRIKE) == Rules.COUNT_NUMBER) {
            return SUCCESS;
        }
        return FAIL;
    }
}
