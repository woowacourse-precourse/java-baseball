package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class functionTest {
    @Test
    void 올바른_형식의_답을_만들었는지_확인() {
        List<Integer> allowedInteger = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> answer = Application.createAnswer();
        Set<Integer> answerSet = new HashSet<>(answer);

        for (Integer eachAnswerNumber : answerSet) {
            if (!allowedInteger.contains(eachAnswerNumber)) {
                throw new IllegalArgumentException("0~9 안의 숫자가 아님");
            }
        }

        assertThat(answer.size()).isEqualTo(answerSet.size());
        assertThat(answer.size()).isEqualTo(3);

    }

    @Test
    void 인풋_발리데이션_로직_체크() {
        //given
        List<Integer> correctInput = List.of(1, 2, 3);
        List<Integer> duplciateinput = List.of(1, 2, 2);
        List<Integer> outOfRangeInput = List.of(1, 2, 10);
        List<Integer> negativeInput = List.of(1, 2, -5);
        List<Integer> fourInput = List.of(1, 2, 3, 4);

        //then
        assertThat(Application.validateInput(correctInput)).isEqualTo(true);
        assertThatThrownBy(() -> Application.validateInput(duplciateinput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateInput(outOfRangeInput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateInput(negativeInput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateInput(negativeInput)).isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    void 케이스별_인풋과_정답_비교() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> input1 = List.of(1, 2, 3); // 3스트라이크
        List<Integer> input2 = List.of(4, 5, 6); // 낫싱
        List<Integer> input3 = List.of(2, 1, 3); // 2볼 1스트라이크
        List<Integer> input4 = List.of(5, 1, 3); // 1볼 1스트라이크
        List<Integer> input5 = List.of(0, 3, 2);// 2볼
        List<Integer> input6 = List.of(0, 2, 4);// 1스트라이크
        List<Integer> input7 = List.of(3, 1, 2);// 3볼

        assertThat(Application.compareAnswerToInput(answer, input1)).containsExactly(0,3);
        System.out.println("3스트라이크 통과");

        assertThat(Application.compareAnswerToInput(answer, input2)).containsExactly(0,0);
        System.out.println("낫싱 통과");

        assertThat(Application.compareAnswerToInput(answer, input3)).containsExactly(2,1);
        System.out.println("2볼 1스트라이크 통과");

        assertThat(Application.compareAnswerToInput(answer, input4)).containsExactly(1,1);
        System.out.println("1볼 1스트라이크 통과");

        assertThat(Application.compareAnswerToInput(answer, input5)).containsExactly(2, 0);
        System.out.println("2볼 통과");

        assertThat(Application.compareAnswerToInput(answer, input6)).containsExactly(0,1);
        System.out.println("1스트라이크 통과");

        assertThat(Application.compareAnswerToInput(answer, input7)).containsExactly(3,0);
        System.out.println("3스트라이크 통과");

    }

    @Test
    void 볼과_스트라이크_프린트_체크() {
        assertThat(Application.printBallAndStrike(List.of(0, 0))).isEqualTo("낫싱");
        assertThat(Application.printBallAndStrike(List.of(1, 0))).isEqualTo("1볼");
        assertThat(Application.printBallAndStrike(List.of(0, 1))).isEqualTo("1스트라이크");
        assertThat(Application.printBallAndStrike(List.of(1, 1))).isEqualTo("1볼 1스트라이크");
    }
}
