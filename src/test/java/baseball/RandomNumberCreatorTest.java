package baseball;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberCreatorTest {

    @RepeatedTest(50)
    void _1_9_까지_랜덤숫자_한개_생성() {
        int result = RandomNumberCreator.createRandomNumber();
        assertThat(result).isBetween(1, 9);
    }
}
