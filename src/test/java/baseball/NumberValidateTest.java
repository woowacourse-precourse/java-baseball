package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberValidateTest {

    @TestFactory
    @DisplayName("입력 숫자의 유효성을 검증하는 기능을 테스트한다.")
    Stream<DynamicTest> numberValidateTest() {
        NumberValidate numberValidate = new NumberValidate();

        return Stream.of(
                DynamicTest.dynamicTest("유효성 검증을 통과한 경우", () -> {

                    numberValidate.validation(467);
                }),
                DynamicTest.dynamicTest("3자리 숫자가 아닌경우 예외를 던져준다.", () -> {

                    assertThatThrownBy(() -> numberValidate.validation(47))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("3자리 숫자만 입력 가능합니다.");
                }),
                DynamicTest.dynamicTest("중복된 숫자가 있을경우 예외를 던져준다.", () -> {
                    assertThatThrownBy(() -> numberValidate.validation(454))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("3개의 숫자는 서로 다른 숫자만 입력 가능합니다.");
                }),
                DynamicTest.dynamicTest("0이 포함된 경우 예외를 던져준다.", () -> {
                    assertThatThrownBy(() -> numberValidate.validation(401))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("1부터 9까지의 숫자만 입력 가능합니다.");
                })
        );
    }
}
