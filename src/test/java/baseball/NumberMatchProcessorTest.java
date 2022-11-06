package baseball;

import baseball.processor.NumberMatchProcessor;
import baseball.processor.NumberMatchProcessorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;


import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class NumberMatchProcessorTest {

    private NumberMatchProcessor numberMatchProcessor;

    @TestFactory
    @DisplayName("야구숫자게임의 숫자비교기능을 테스트한다.")
    Stream<DynamicTest> numberMatchTest() {
        final List<Integer> gameNumber = List.of(1, 2, 3);
        numberMatchProcessor = new NumberMatchProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("하나도 일치하지 않는 경우", () -> {
                    List<Integer> userNumber = List.of(4, 5, 6);
                    List<Integer> result = numberMatchProcessor.compare(gameNumber, userNumber);

                    assertThat(result).contains(0);
                    assertThat(result).containsExactly(0, 0);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("1스트라이크인 경우", () -> {
                    List<Integer> userNumber = List.of(4, 5, 3);
                    List<Integer> result = numberMatchProcessor.compare(gameNumber, userNumber);

                    assertThat(result).contains(0, 1);
                    assertThat(result).containsExactly(1, 0);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("1볼인 경우", () -> {
                    List<Integer> userNumber = List.of(4, 5, 2);
                    List<Integer> result = numberMatchProcessor.compare(gameNumber, userNumber);

                    assertThat(result).contains(0, 1);
                    assertThat(result).containsExactly(0, 1);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("1볼 1스트라이크인 경우", () -> {
                    List<Integer> userNumber = List.of(1, 5, 2);
                    List<Integer> result = numberMatchProcessor.compare(gameNumber, userNumber);

                    assertThat(result).contains(1, 1);
                    assertThat(result).containsExactly(1, 1);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("2볼 1스트라이크인 경우", () -> {
                    List<Integer> userNumber = List.of(1, 3, 2);
                    List<Integer> result = numberMatchProcessor.compare(gameNumber, userNumber);

                    assertThat(result).contains(1, 2);
                    assertThat(result).containsExactly(1, 2);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("3개의 숫자를 모두 맞힐 경우", () -> {
                    List<Integer> userNumber = List.of(1, 2, 3);
                    List<Integer> result = numberMatchProcessor.compare(gameNumber, userNumber);

                    assertThat(result).contains(0, 3);
                    assertThat(result).containsExactly(3, 0);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("다른 크기의 배열을 입력받으면 예외를 던져준다.", () -> {
                    List<Integer> userNumber = List.of(1, 2, 3, 4);
                    assertThatThrownBy(() -> numberMatchProcessor.compare(gameNumber, userNumber))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력 대상의 배열 크기가 다릅니다.");
                })
        );
    }
}
