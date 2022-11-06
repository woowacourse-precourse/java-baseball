package baseball.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InitializationTest {

    @Test
    void createTargetNumber() {

        String targetNumber = Initialization.createTargetNumber();
        char first = targetNumber.charAt(0);
        char second = targetNumber.charAt(1);
        char third = targetNumber.charAt(2);

        assertThat(targetNumber).isNotNull();
        assertThat(first).isNotEqualTo(second);
        assertThat(second).isNotEqualTo(third);
        assertThat(third).isNotEqualTo(first);

    }

}