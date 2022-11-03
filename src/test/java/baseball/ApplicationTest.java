package baseball;

import baseball.controller.BaseballController;
import baseball.model.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도값이_숫자가_아닌_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a2"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도값이_옳은_길이가_아닌_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도값에_중복값이_있는_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    static class BaseballTest extends BaseballController {

        final String TEST_CASE_ANSWER = "634";
        final int TEST_CASE_LENGTH = 3;

        private String getAnswer(){
            return answer;
        }

        private void setAnswer(String newAnswer){
            super.answer = newAnswer;
        }

        @Test
        void 정답이_옳은_길이_인지_확인(){
            assertThat(getAnswer().length()).isEqualTo(super.ANSWER_LENGTH);
        }

        @Test
        void 정답이_숫자만_있는지_확인(){
            String answer = getAnswer();
            Pattern compile = Pattern.compile("/^[0-9]*$/");
            assertThat(compile.matcher(answer)).isTrue();
        }

        @Test
        void 정답에_중복숫자가_없는지_확인(){
            String answer = getAnswer();
            String distinctString = Util.getDistinctString(answer);
            assertThat(answer).isEqualTo(distinctString);
        }

        @Test
        void 입력값_333_시_예외발생(){
            setAnswer(TEST_CASE_ANSWER);
            assertThatThrownBy(() -> new Validator("333", TEST_CASE_LENGTH))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력값_abc_시_예외발생(){
            setAnswer(TEST_CASE_ANSWER);
            assertThatThrownBy(() -> new Validator("abc", TEST_CASE_LENGTH))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력값_3$4_시_예외발생(){
            setAnswer(TEST_CASE_ANSWER);
            assertThatThrownBy(() -> new Validator("3$4", TEST_CASE_LENGTH))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력값_34_시_예외발생(){
            setAnswer(TEST_CASE_ANSWER);
            assertThatThrownBy(() -> new Validator("34", TEST_CASE_LENGTH))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 입력값_346_시_결과(){
            setAnswer(TEST_CASE_ANSWER);
            assertThat(super.answerCheck("346")).isEqual("3볼");
        }

        @Test
        void 입력값_152_시_결과(){
            setAnswer(TEST_CASE_ANSWER);
            assertThat(super.answerCheck("152")).isEqual("낫싱");
        }

        @Test
        void 입력값_673_시_결과(){
            setAnswer(TEST_CASE_ANSWER);
            assertThat(super.answerCheck("673")).isEqual("1볼 1스트라이크");
        }

        @Test
        void 입력값_634_시_결과(){
            setAnswer(TEST_CASE_ANSWER);
            assertThat(super.answerCheck("634")).isEqual("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
