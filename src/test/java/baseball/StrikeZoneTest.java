package baseball;

import baseball.participants.StrikeZone;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StrikeZoneTest {
    @Test
    void String1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new StrikeZone("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void String2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new StrikeZone("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void String4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new StrikeZone("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void intList1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new StrikeZone(List.of(1)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void intList2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new StrikeZone(List.of(1, 2)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void intList4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new StrikeZone(List.of(1, 2, 3, 4)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
