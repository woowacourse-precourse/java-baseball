package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    Application application = new Application();


    @Test
    @DisplayName("getBall 메서드 테스트")
    void getBallTest() {
        List<Integer> answer = List.of(2, 2, 2);
        List<Integer> userInput = List.of(3, 2, 2);

        assertThat(application.getBall(answer, userInput)).isEqualTo(2);
    }

    @Test
    @DisplayName("getValidUserInput 테스트")
    void getValidUserInputTest() {

        String generalInput = "123";
        String exceptInput01 = " 12";
        String exceptInput02 = "1-1";
        String exceptInput03 = "a12";

        assertThat(application.getValidUserInput(generalInput).size()).isEqualTo(3);
        assertThat(application.getValidUserInput(generalInput)).containsExactly(1, 2, 3);

        assertThatThrownBy(() -> application.getValidUserInput(exceptInput01))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력값 입니다.");

        assertThatThrownBy(() -> application.getValidUserInput(exceptInput02))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력값 입니다.");

        assertThatThrownBy(() -> application.getValidUserInput(exceptInput03))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력값 입니다.");

    }

    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void createNewAnswerTest() {
        List<Integer> newAnswer = application.createNewAnswer();
        assertThat(newAnswer.size()).isEqualTo(3);
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
