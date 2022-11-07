package baseball.validation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    void Validator_모두_통과() {
        Validator validator = Validator.getInstance();

        List<Condition> conditions = List.of(
                getTrueCondition(),
                getTrueCondition()
        );

        assertThat(validator.isAnyConditionsFalse(1, conditions)).isFalse();
    }

    @Test
    void Validator_일부_불통() {
        Validator validator = Validator.getInstance();

        List<Condition> conditions = List.of(
                getTrueCondition(),
                getFalseCondition()
        );

        assertThat(validator.isAnyConditionsFalse(1, conditions)).isTrue();
    }

    private Condition getTrueCondition() {
        return new Condition() {
            @Override
            public Boolean isTrue(Integer guess) {
                return true;
            }
        };
    }

    private Condition getFalseCondition() {
        return new Condition() {
            @Override
            public Boolean isTrue(Integer guess) {
                return false;
            }
        };
    }
}