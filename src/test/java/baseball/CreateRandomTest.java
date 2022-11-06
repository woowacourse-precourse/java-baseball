package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CreateRandomTest {
    private CreateRandom createRandom;

    @BeforeEach
    void setUp() {
        this.createRandom = new CreateRandom();
    }


    @AfterEach
    void tearDown() {
        this.createRandom = null;
    }

    @Test
    void 만들어진_난수의_길이_테스트() {
        int[] randomNums = createRandom.makeRandomNums();
        assertThat(randomNums.length).isEqualTo(3);
    }

    @Test
    void 만들어진_난수의_각요소가_서로다른지_테스트() {
        int[] randomNums = createRandom.makeRandomNums();
        assertThat(Arrays.stream(randomNums).distinct().count()).isEqualTo(3);
    }
}
