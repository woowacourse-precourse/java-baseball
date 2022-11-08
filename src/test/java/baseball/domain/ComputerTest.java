package baseball.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    private static final int LENGTH = 3;

    @Test
    void getRandomNumber() {
        String randomNumberString = Computer.getRandomNumberString();

        assertThat(randomNumberString).isNotNull();
        assertThat(randomNumberString.length()).isEqualTo(LENGTH);
    }


}
