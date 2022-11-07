package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HintReaderTest {

    @Test
    void 쓰리스트라이크_성공() {
        HintReader hintReader = new HintReader(List.of(Hint.STRIKE, Hint.STRIKE, Hint.STRIKE));

        assertThat(hintReader.isThreeStrike()).isTrue();
    }

    @Test
    void 쓰리스트라이크_실패1() {
        HintReader hintReader = new HintReader(List.of(Hint.STRIKE, Hint.STRIKE, Hint.BALL));

        assertThat(hintReader.isThreeStrike()).isFalse();
    }

    @Test
    void 쓰리스트라이크_실패2() {
        HintReader hintReader = new HintReader(List.of(Hint.NOTHING, Hint.NOTHING, Hint.NOTHING));

        assertThat(hintReader.isThreeStrike()).isFalse();
    }

    @Test
    void 쓰리스트라이크_실패3() {
        HintReader hintReader = new HintReader(List.of(Hint.NOTHING, Hint.NOTHING, Hint.STRIKE));

        assertThat(hintReader.isThreeStrike()).isFalse();
    }

    @Test
    void 스트링변환1() {
        HintReader hintReader = new HintReader(List.of(Hint.NOTHING, Hint.NOTHING, Hint.STRIKE));
        String hintString = hintReader.toHintString();
        String result=new String("1스트라이크\n");
        assertThat(hintString).isEqualTo(result);
    }

    @Test
    void 스트링변환2() {
        HintReader hintReader = new HintReader(List.of(Hint.NOTHING, Hint.NOTHING, Hint.NOTHING));
        String hintString = hintReader.toHintString();
        String result=new String("낫싱\n");
        assertThat(hintString).isEqualTo(result);
    }

    @Test
    void 스트링변환3() {
        HintReader hintReader = new HintReader(List.of(Hint.BALL, Hint.BALL, Hint.NOTHING));
        String hintString = hintReader.toHintString();
        String result=new String("2볼\n");
        assertThat(hintString).isEqualTo(result);
    }
}