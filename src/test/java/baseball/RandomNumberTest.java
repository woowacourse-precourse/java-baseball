package baseball;

import baseball.processor.GameInitProcessor;
import baseball.processor.GameInitProcessorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    private GameInitProcessor gameInitProcessor;

    @TestFactory
    @DisplayName("랜덤으로 숫자를 만드는 기능을 테스트한다.")
    Stream<DynamicTest> numberMatchTest() {
        gameInitProcessor = new GameInitProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("3자리 숫자 생성", () -> {
                    Integer size = 3;
                    List<Integer> result = gameInitProcessor.randomNumber(size);
                    assertThat(result.size()).isEqualTo(3);
                }),
                DynamicTest.dynamicTest("4자리 숫자 생성", () -> {
                    Integer size = 4;
                    List<Integer> result = gameInitProcessor.randomNumber(size);
                    assertThat(result.size()).isEqualTo(4);
                })
        );
    }
}

