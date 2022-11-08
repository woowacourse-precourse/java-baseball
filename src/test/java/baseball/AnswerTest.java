package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest extends NsTest {
    Answer answer;

    @Test
    void 스트라이크_카운트(){
        List<Integer> random = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(1, 2, 5);

        assertThat(answer.getStrikeCnt(random, input)).isEqualTo(2);
    }

    @Test
    void 볼_카운트(){
        List<Integer> random = Arrays.asList(1, 2, 3);
        List<Integer> input = Arrays.asList(2, 3, 1);

        assertThat(answer.getBallCnt(random, input)).isEqualTo(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
