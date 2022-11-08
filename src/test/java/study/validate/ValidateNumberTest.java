package study.validate;

import baseball.validate.ValidateNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNumberTest {

    @Test
    void 수가_목록에_있는_수_인지_확인() {

        assertThrows(IllegalArgumentException.class,
                        () -> ValidateNumber.validateInList(3));

    }
}