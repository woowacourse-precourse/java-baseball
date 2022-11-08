package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class HintTest {
    private static Hint hint;
    private static List<Integer> answerList;

    @BeforeAll
    static void setup(){
        answerList = List.of(1,2,3);
        hint = new Hint(answerList);
    }

    @Test
    void 스트라이크만_발생() {
        //given
        List<Integer> guess = List.of(1,2,4);

        //when
        String hintMsg = hint.retrieve(guess);

        //then
        assertThat(hintMsg).isEqualTo(String.format(HintMessage.STRIKE.message(), 2));
    }

    @Test
    void 볼만_발생() {
        //given
        List<Integer> guess = List.of(3,1,4);

        //when
        String hintMsg = hint.retrieve(guess);

        //then
        assertThat(hintMsg).isEqualTo(String.format(HintMessage.BALL.message(), 2));
    }

    @Test
    void 스트라이크와_볼_발생() {
        //given
        List<Integer> guess = List.of(1,3,4);

        //when
        String hint = HintTest.hint.retrieve(guess);

        //then
        assertThat(hint).isEqualTo(String.format(HintMessage.STRIKE_AND_BALL.message(), 1, 1));
    }

    @Test
    void 스트라이크와_볼_전부_미발생시_낫싱() {
        //given
        List<Integer> guess = List.of(4,4,4);

        //when
        String hint = HintTest.hint.retrieve(guess);

        //then
        assertThat(hint).isEqualTo(HintMessage.NOTHING.message());
    }
}