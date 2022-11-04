package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntComparatorTest {
    @DisplayName("다른 수라면 false를 반환한다")
    @Test
    void returnFalse() {
        assertFalse(IntComparator.isEqual(1, 2));
    }

    @DisplayName("같은 수라면 true를 반환한다")
    @Test
    void returnTrue() {
        assertTrue(IntComparator.isEqual(3, 3));
    }
}