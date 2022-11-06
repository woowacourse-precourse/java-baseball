package baseball.service;

import baseball.domain.Again;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Validator;

public class AgainValidator {
    final static int EXCEPTION = -1;
    final static int ALL_RIGHT = 1;

    public void validate(Again again) {
        if (againValueCheck(again.getDoTry()) == EXCEPTION) {
            throw new IllegalArgumentException();
        }
    }

    public int againValueCheck(int doTry) {
        if (doTry == 1 || doTry == 2) {
            return ALL_RIGHT;
        }
        return EXCEPTION;
    }
}
