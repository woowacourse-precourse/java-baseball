package baseball;

import baseball.processor.NumberValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberValidateTest {

    @TestFactory
    @DisplayName("입력 숫자의 유효성을 검증하는 기능을 테스트한다.")
    Stream<DynamicTest> numberValidateTest() {
        NumberValidate numberValidate = new NumberValidate();
        final Integer size = 3;
        return Stream.of(
                DynamicTest.dynamicTest("유효성 검증을 통과한 경우", () -> {
                    final List<Integer> gameNumber = List.of(1, 2, 3);
                    numberValidate.validation(gameNumber, size);
                }),
                DynamicTest.dynamicTest("사이즈가 다른경우 예외를 던져준다. case 2자리 숫자", () -> {
                    final List<Integer> gameNumber = List.of(1, 3);
                    assertThatThrownBy(() -> numberValidate.validation(gameNumber, size))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("3자리 숫자만 입력 가능합니다.");
                }),
                DynamicTest.dynamicTest("사이즈가 다른경우 예외를 던져준다. case 4자리 숫자", () -> {
                    final List<Integer> gameNumber = List.of(1, 3, 5, 6);
                    assertThatThrownBy(() -> numberValidate.validation(gameNumber, size))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("3자리 숫자만 입력 가능합니다.");
                }),
                DynamicTest.dynamicTest("중복된 숫자가 있을경우 예외를 던져준다.", () -> {
                    final List<Integer> gameNumber = List.of(4, 5, 4);
                    assertThatThrownBy(() -> numberValidate.validation(gameNumber, size))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("3개의 숫자는 서로 다른 숫자만 입력 가능합니다.");
                }),
                DynamicTest.dynamicTest("0이 포함된 경우 예외를 던져준다.", () -> {
                    final List<Integer> gameNumber = List.of(4, 0, 1);
                    assertThatThrownBy(() -> numberValidate.validation(gameNumber, size))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("1부터 9까지의 숫자만 입력 가능합니다.");
                })
        );
    }
}
