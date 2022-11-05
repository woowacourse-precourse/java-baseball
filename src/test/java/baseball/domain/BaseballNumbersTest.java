package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballNumbers 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballNumbersTest {

    @Nested
    class 생성자는 {

        @Nested
        class 만약_범위를_벗어난_크기의_리스트를_입력_받으면 {
            List<BaseballNumber> givenList = List.of(BaseballNumber.valueOf(1));

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> new BaseballNumbers(givenList))
                        .isInstanceOf(BaseballGameException.class);
            }
        }

        @Nested
        class 만약_중복된_숫자가_들어간_리스트를_입력_받으면 {
            List<BaseballNumber> givenList = List.of(
                    BaseballNumber.valueOf(1),
                    BaseballNumber.valueOf(1),
                    BaseballNumber.valueOf(4)
            );

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> new BaseballNumbers(givenList))
                        .isInstanceOf(BaseballGameException.class);
            }
        }
    }
}
