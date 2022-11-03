package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

public class HintTest {
    //Hint getHint count 함수 주석처리 하고 해야함

    @Test
    void 볼() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(2, 1, 9);

        Hint hint = new Hint();
        hint.countMatchingNumbers(computer, user);
        hint.countIncludedNumbers(computer, user);

        Assertions.assertThat(hint.getHint()).isEqualTo("2볼");
    }

    @Test
    void 볼스트라이크() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(2, 4, 3);

        Hint hint = new Hint();
        hint.countMatchingNumbers(computer, user);
        hint.countIncludedNumbers(computer, user);

        Assertions.assertThat(hint.getHint()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 스트라이크() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);

        Hint hint = new Hint();
        hint.countMatchingNumbers(computer, user);
        hint.countIncludedNumbers(computer, user);

        Assertions.assertThat(hint.getHint()).isEqualTo("3스트라이크");
    }

    @Test
    void 낫싱() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(4, 5, 6);

        Hint hint = new Hint();
        hint.countMatchingNumbers(computer, user);
        hint.countIncludedNumbers(computer, user);

        Assertions.assertThat(hint.getHint()).isEqualTo("낫싱");
    }
}
