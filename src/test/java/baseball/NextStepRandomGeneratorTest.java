package baseball;

import baseball.generator.NextStepRandomGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class NextStepRandomGeneratorTest {

    private final NextStepRandomGenerator generator = new NextStepRandomGenerator();

    @ParameterizedTest(name = "{0} 입력시 생성 배열 자리수 체크")
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤_생성_자리수_체크(int size) {
        List<Integer> randomNumber = generator.generate(size);
        assertThat(randomNumber.size()).isEqualTo(size);
    }

    @Test
    void 랜덤_3자리수_중복_체크() {
        final int attemptCount = 30;
        for (int i = 1; i <= attemptCount; i++) {
            List<Integer> randomNumber = generator.generate(3);
            Set<Integer> dupCheckSet = new HashSet<>(randomNumber);
            assertThat(randomNumber.size()).isEqualTo(dupCheckSet.size());
        }
    }

    @Test
    void 배열_자리수_음수_예외() {
        assertThatThrownBy(() -> generator.generate(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
