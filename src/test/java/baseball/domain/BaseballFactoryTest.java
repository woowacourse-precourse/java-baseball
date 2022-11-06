package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseballFactory 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballFactoryTest {
    private BaseballNumberFactory sut = new BaseballNumberFactory();

    @Nested
    class generate_메서드는 {

        @Nested
        class 서로_다른_1부터_9사이의_임의의_수_3개를_생성하여 {

            @Test
            void 반환한다() {
                List<BaseballNumber> result = sut.generate();

                HashSet<BaseballNumber> nonDuplicateBaseballs = new HashSet<>(result);

                assertThat(nonDuplicateBaseballs.size()).isEqualTo(3L);
            }
        }
    }
}
