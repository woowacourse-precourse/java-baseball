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

    @BeforeEach
    public void init() {
        c = new Catcher();
        c.forTest_setter(); // 테스트를 위해 catcher에 임의로 713 저장
    }

    @Test
    void 힌트생성() {
        String[] cases = {"854", "714", "137", "721", "713"};
        String[] answers = {"낫싱", "2스트라이크", "3볼", "1볼 1스트라이크", "3스트라이크"};

        for (int i = 0; i < cases.length; i++) {
            p = new Pitcher(cases[i]);
            hintGenerator = new HintGenerator(p, c);
            String hint = hintGenerator.generateHint();
            assertThat(hint).isEqualTo(answers[i]);
        }

    }
}