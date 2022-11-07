package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HintTest {
    private Hint hint = new Hint();

    @Test
    void 플레이어_입력값에_따라_볼과_스트라이크_개수를_알려준다(){
        List<Integer> playerInputs1 = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> randomNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<Integer> playerInputs2 = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> randomNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<Integer> playerInputs3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNumbers3 = new ArrayList<>(Arrays.asList(4, 5, 6));

        List<Integer> playerInputs4 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNumbers4 = new ArrayList<>(Arrays.asList(1, 5, 6));

        String result1 = hint.calculateResult(playerInputs1, randomNumbers1);
        String result2 = hint.calculateResult(playerInputs2, randomNumbers2);
        String result3 = hint.calculateResult(playerInputs3, randomNumbers3);
        String result4 = hint.calculateResult(playerInputs4, randomNumbers4);


        Assertions.assertThat(result1).isEqualTo("2볼 1스트라이크");
        Assertions.assertThat(result2).isEqualTo("3볼");
        Assertions.assertThat(result3).isEqualTo("낫싱");
        Assertions.assertThat(result4).isEqualTo("1스트라이크");
    }

    @Test
    void 만약_3스트라이크면_isThreeStrike_메소드는_true를_반환한다(){

        List<Integer> playerInputs = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));

        hint.calculateResult(playerInputs, randomNumbers);
        boolean result = hint.isThreeStrike();

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 만약_3스트라이크가_아니라면_isThreeStrike_메소드는_false를_반환한다(){
        List<Integer> playerInputs = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(1, 3, 2));

        hint.calculateResult(playerInputs, randomNumbers);
        boolean result = hint.isThreeStrike();

        Assertions.assertThat(result).isFalse();
    }
}