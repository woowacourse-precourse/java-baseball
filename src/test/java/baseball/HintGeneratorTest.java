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

    @Test
    void 입력이_숫자가_아닌_경우() {
        p = new Pitcher("abc");
        hintGenerator = new HintGenerator(p, c);

        assertThatThrownBy(() -> hintGenerator.generateHint())
                .isInstanceOf(IllegalFormatException.class)
                .hasMessageContaining("숫자 형식으로 입력해주세요");
    }

    @Test
    void 입력의_숫자가_중복될_경우() {
        p = new Pitcher("111");
        hintGenerator = new HintGenerator(p, c);
        assertThatThrownBy(() -> hintGenerator.generateHint())
                .isInstanceOf(ShouldNotHaveDuplicates.class)
                .hasMessageContaining("중복되지 않는 수를 입력해주세요");
    }

    @Test
    void 입력된_숫자의_길이가_다를_경우() {
        p = new Pitcher("1234");
        hintGenerator = new HintGenerator(p, c);
        assertThatThrownBy(() -> hintGenerator.generateHint())
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("3자리 수로 입력해주세요");


    }
}