package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlayerTest {
    private static final int COUNT_VALUE = 3;
    @Test
    void getPredictedValue() {
        //given
        Player player = new Player();
        int arr[] = new int[]{1, 2, 3};
        player.setPredictedValue("123");

        //when
        int result[] = player.getPredictedValue();

        //then
        assertArrayEquals(result, arr);
    }

    @Test
    void setPredictedValue() {
        //given
        Player player = new Player();
        String input = "123456";

        //when
        player.setPredictedValue(input);
        int result[] = player.getPredictedValue();

        //then
        assertThat(result.length).isNotEqualTo(input.length());
        assertThat(result.length).isEqualTo(COUNT_VALUE);

    }
}