package baseball.domain;

import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberCreatorTest {

    @RepeatedTest(50)
    void _1_9_까지_랜덤숫자_한개_생성() {
        int result = RandomNumberCreator.createRandomNumber();
        assertThat(result).isBetween(1, 9);
    }

    @RepeatedTest(50)
    void _1_9_까지_서로다른_랜덤숫자_3개_생성() {
        List<Integer> result = RandomNumberCreator.createRandomNumbers();
        for (int randomNumber : result) {
            assertThat(randomNumber).isBetween(1, 9);
        }
    }
}
