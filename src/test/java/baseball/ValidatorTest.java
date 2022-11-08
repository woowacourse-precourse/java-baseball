package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import baseball.Utils.Validator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @BeforeEach
    void setUp() {
        System.out.println("ValidatorTest | Before Each setUp() method called");
    }

    @AfterEach
    void tearDown() {
        System.out.println("ValidatorTest | After Each tearDown() method called");
    }

    @Test
    void isNumeric_메서드로_숫자가_아닌_경우_예외_발생() {
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.isNumeric("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void checkGuessLength_메서드로_길이가_3이_아닌_경우_예외_발생() {
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkGuessLength("34"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkGuessLength("98765"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void checkRange_메서드로_정해진_숫자의_범위가_아닌_경우_예외_발생() {
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkRange(0))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void checkFlagLength_메서드로_정해진_숫자의_범위가_아닌_경우_예외_발생() {
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkRange(0))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void checkFlag_메서드로_정해진_플래그가_아닌_경우_예외_발생() {
        Validator validator = new Validator();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkFlag("7"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}