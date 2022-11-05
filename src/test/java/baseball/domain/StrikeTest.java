package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[Strike 클래스 테스트]")
class StrikeTest {

    @DisplayName("단위 메소드 테스트")
    @Nested
    class Test1 {
        final Strike strike = new Strike();

        @Test
        @DisplayName("strike 객체가 잘 생성실되었는가?")
        void strike() {
            assertAll(
                    () -> assertNotNull(strike),
                    () -> assertEquals(strike.strike(), 0)
            );
        }

        @ParameterizedTest()
        @DisplayName("strike 객체의 addStrike 메소드가 잘 실행되는가?")
        @ValueSource(ints = {1, 2, 3, 4, 0, 7})
        void addStrike(final int num) {
            for(int i = 0; i < num; i++) {
                strike.addStrike();
            }
            assertEquals(strike.strike(), num);
        }

        @Test
        @DisplayName("strike 객체의 clearBall 메소드가 잘 실행되는가?")
        void clearStrike() {
            strike.clearStrike();
            assertEquals(strike.strike(), 0);
        }
    }

    @Test
    @DisplayName("통합적으로 Strike 클래스가 제대로 실행되는가?")
    void IntegratedTest() {
        final var strike1 = new Strike();
        final var strike2 = new Strike();

        strike1.addStrike();
        strike1.addStrike();

        strike2.addStrike();

        assertAll(
                () -> assertEquals(strike1.strike(), 2),
                () -> assertEquals(strike2.strike(), 1)
        );

        strike1.clearStrike();
        strike2.clearStrike();

        assertEquals(strike1.strike(), strike2.strike());
    }
}