package baseball;

import org.assertj.core.error.ShouldNotHaveDuplicates;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;

import static org.assertj.core.api.Assertions.*;

class HintGeneratorTest {

    Catcher c;
    Pitcher p;
    HintGenerator hintGenerator;

    @BeforeAll
    public void init() {
        c = new Catcher();
        c.forTest_setter(); // 테스트를 위해 catcher에 임의로 713 저장
    }

    @Test
    void 힌트생성_1볼_1스트라이크() {
        p = new Pitcher("123");
        hintGenerator = new HintGenerator(p, c);
        String hint = hintGenerator.generateHint();
        assertThat(hint).isEqualTo("1볼 1스트라이크");
    }
}