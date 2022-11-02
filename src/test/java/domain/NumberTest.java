package domain;

import constant.Messages;
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

    @Test
    void 입력이_3개의_숫자가_아니라면_예외_발생() {
        List<Number> list = new ArrayList<>();
        list.add(new Number(3));
        list.add(new Number(2));
        list.add(new Number(1));
        list.add(new Number(6));
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Numbers(list));
        assertEquals("입력은 3자리 숫자만 가능합니다.", exception.getMessage());
    }

    @Test
    void 각_숫자_중복되는_경우_예외_발생() {
        List<Number> list = new ArrayList<>();
        list.add(new Number(2));
        list.add(new Number(2));
        list.add(new Number(2));

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Numbers(list));
        assertEquals(Messages.duplicateNumber, exception.getMessage());
    }
}
