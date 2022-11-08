package baseball.validation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    private static final String ERROR_MESSAGE_PASS = "true condition";
    private static final String ERROR_MESSAGE_FAIL = "false condition";

    @Test
    void Validator_모두_통과() {
        Validator validator = Validator.getInstance();

        List<Condition> conditions = List.of(
                getTrueCondition(),
                getTrueCondition()
        );

        assertThat(validator.getNotPassConditionIndex("", conditions)).isEqualTo(-1);
    }

    @Test
    void Validator_일부_불통() {
        Validator validator = Validator.getInstance();

        List<Condition> conditions = List.of(
                getTrueCondition(),
                getFalseCondition()
        );

        Integer notPassConditionIndex = validator.getNotPassConditionIndex("", conditions);
        Condition notPassCondition = conditions.get(notPassConditionIndex);

        assertThat(notPassConditionIndex).isEqualTo(1);
        assertThat(notPassCondition.getErrorMessage()).isEqualTo(ERROR_MESSAGE_FAIL);
    }

    private Condition getTrueCondition() {
        return new Condition() {
            @Override
            public Boolean isTrue(String guess) {
                return true;
            }

            @Override
            public String getErrorMessage() {
                return ERROR_MESSAGE_PASS;
            }
        };
    }

    private Condition getFalseCondition() {
        return new Condition() {
            @Override
            public Boolean isTrue(String guess) {
                return false;
            }

            @Override
            public String getErrorMessage() {
                return ERROR_MESSAGE_FAIL;
            }
        };
    }
}