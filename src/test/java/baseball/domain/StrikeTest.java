package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StrikeTest {

    @Nested
    class Test1 {
        final Strike strike = new Strike();

        @Test
        void strike() {
            assertAll(
                    () -> assertNotNull(strike),
                    () -> assertEquals(strike.strike(), 0)
            );
        }

        @ParameterizedTest()
        @ValueSource(ints = {1, 2, 3, 4, 0, 7})
        void addStrike(final int num) {
            strike.putStrike(num);
            assertEquals(strike.strike(), num);
        }

        @Test
        void clearStrike() {
            strike.clearStrike();
            assertEquals(strike.strike(), 0);
        }
    }

    @DisplayName("메소드 통합 테스트")
    @Test
    void IntegratedTest() {
        final var strike1 = new Strike();
        final var strike2 = new Strike();

        strike1.putStrike(2);

        strike2.putStrike(1);

        assertAll(
                () -> assertEquals(strike1.strike(), 2),
                () -> assertEquals(strike2.strike(), 1)
        );

        strike1.clearStrike();
        strike2.clearStrike();

        assertEquals(strike1.strike(), strike2.strike());
    }
}