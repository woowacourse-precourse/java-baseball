package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberTest {
    @Test
    void 각_숫자의_범위가_벗어났으면_예외_발생() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Number(0));
        assertEquals("1부터 9까지의 숫자만 가능합니다.", exception.getMessage());
    }

}
