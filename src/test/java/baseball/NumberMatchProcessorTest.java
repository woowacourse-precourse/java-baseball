package baseball;

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
        final int gameNumber = 123;
        numberMatchProcessor = new NumberMatchProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("하나도 일치하지 않는 경우", () -> {

                    List<Integer> result = numberMatchProcessor.compare(gameNumber, 456);

                    assertThat(result).contains(0);
                    assertThat(result).containsExactly(0, 0);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("1스트라이크인 경우", () -> {

                    List<Integer> result = numberMatchProcessor.compare(gameNumber, 453);

                    assertThat(result).contains(0, 1);
                    assertThat(result).containsExactly(1, 0);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("1볼인 경우", () -> {

                    List<Integer> result = numberMatchProcessor.compare(gameNumber, 452);

                    assertThat(result).contains(0, 1);
                    assertThat(result).containsExactly(0, 1);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("1볼 1스트라이크인 경우", () -> {

                    List<Integer> result = numberMatchProcessor.compare(gameNumber, 152);

                    assertThat(result).contains(1, 1);
                    assertThat(result).containsExactly(1, 1);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("3개의 숫자를 모두 맞힐 경우", () -> {

                    List<Integer> result = numberMatchProcessor.compare(gameNumber, 123);

                    assertThat(result).contains(0, 3);
                    assertThat(result).containsExactly(3, 0);
                    assertThat(result.size()).isEqualTo(2);

                }),
                DynamicTest.dynamicTest("입력값이 3자리숫자가 아닌경우 예외를 리턴한다. - case 4자리 숫자", () -> {
                    assertThatThrownBy(() -> numberMatchProcessor.compare(gameNumber, 1376))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("3자리 숫자만 입력 가능합니다.");

                }),
                DynamicTest.dynamicTest("입력값이 3자리숫자가 아닌경우 예외를 리턴한다 - case 2자리 숫자.", () -> {
                    assertThatThrownBy(() -> numberMatchProcessor.compare(gameNumber, 97))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("3자리 숫자만 입력 가능합니다.");
                })
        );
    }
}
