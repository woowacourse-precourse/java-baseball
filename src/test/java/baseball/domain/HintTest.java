package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HintTest {
    private Hint hint = new Hint();

    @Test
    void x볼_x스트라이크_테스트(){
        List<Integer> playerInputs = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));

        String result = hint.calculateResult(playerInputs, randomNumbers);

        Assertions.assertThat(result).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void x볼_테스트() {
        List<Integer> playerInputs = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));

        String result = hint.calculateResult(playerInputs, randomNumbers);

        Assertions.assertThat(result).isEqualTo("3볼");
    }

    @Test
    void x스트라이크_테스트() {
        List<Integer> playerInputs = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(1, 5, 6));

        String result = hint.calculateResult(playerInputs, randomNumbers);

        Assertions.assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    void 낫싱_테스트() {
        List<Integer> playerInputs = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(4, 5, 6));

        String result = hint.calculateResult(playerInputs, randomNumbers);

        Assertions.assertThat(result).isEqualTo("낫싱");
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