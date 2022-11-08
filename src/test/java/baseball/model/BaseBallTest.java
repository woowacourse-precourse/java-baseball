package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BaseBall 클래스와 관련된 테스트를 진행한다.")
class BaseBallTest {
    /**
     * when 정답이 생성되어 있고, 접근이 가능하도록 바뀌면
     * then 값에 접근했을 때 크기가 3이 나온다.
     */
    @DisplayName("야구 게임 정답 생성 메서드를 테스트한다.")
    @Test
    void 정답_생성_테스트() {
        //when
        BaseBall baseBall = new BaseBall();
        Field field = getAnswerField(baseBall);

        //then
        정답의_크키가_3이다(baseBall, field);
    }

    private void 정답의_크키가_3이다(BaseBall baseBall, Field field) {
        List<Integer> answer = getAnswer(baseBall, field);
        assertThat(answer).hasSize(3);
    }

    private Field getAnswerField(BaseBall baseBall) {
        Field field = null;
        try {
            field = baseBall.getClass().getDeclaredField("answer");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return field;
    }

    private List<Integer> getAnswer(BaseBall baseBall, Field field) {
        List<Integer> answer = null;
        try {
            answer = (List<Integer>) field.get(baseBall);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @DisplayName("정답과 입력값을 비교하는 메서드 테스트")
    @ParameterizedTest
    @MethodSource("compareInputAndAnswer")
    void compareAnswer(List<Integer> inputs, List<Integer> answers, Score answer) {
        //given
        BaseBall baseBall = new BaseBall() {
            @Override
            protected List<Integer> makeThreeRandomNumbers() {
                return answers;
            }
        };

        //when
        Score score = baseBall.compareAnswer(inputs);

        //then
        assertThat(score).isEqualTo(answer);
    }

    private static Stream<Arguments> compareInputAndAnswer() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), new Score(3, 0)),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 5), new Score(2, 0)),
                Arguments.of(List.of(3, 2, 1), List.of(1, 2, 3), new Score(1, 2)),
                Arguments.of(List.of(3, 2, 1), List.of(1, 3, 2), new Score(0, 3)),
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 7), new Score(1, 1)),
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 7), new Score(0, 0))
        );
    }
}
