package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    BaseballController controller = new BaseballController();

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
    @DisplayName("타겟넘버 생성 테스트")
    void createTargetNumberTest() {
        BaseballController controller = new BaseballController();

        controller.getModel().createTargetNumberList();
        assertThat(controller.getModel().getTargetNumbers().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력값의 길이가 3이상인지 테스트")
    void userInputValidTest() {
        // 예외가 발생하면 성공으로 처리한다.
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값에 0이 있는지 테스트")
    void userInputCheckZero() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("104"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값에 중복된 값이 있는지 테스트")
    void userInputCheckOverlap() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값에 숫자외의 값이 있는지 테스트")
    void userInputCheckNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1c1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("한글입력 테스트")
    void userInputCheckKorean() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1가1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("스트라이크 출력")
    void printStrike() {
        
        controller.getView().printBallcount(1,0);

        assertThat(output()).contains("1스트라이크");
    }

    @Test
    @DisplayName("볼 출력")
    void printBall() {

        controller.getView().printBallcount(0,1);

        assertThat(output()).contains("1볼");

    }

    @Test
    @DisplayName("스트라이크 볼 출력")
    void printBallandStrike() {

        controller.getView().printBallcount(1,1);

        assertThat(output()).contains("1볼 1스트라이크");
    }

    @Test
    @DisplayName("낫싱출력")
    void printNothing() {

        controller.getView().printBallcount(0,0);

        assertThat(output()).contains("낫싱");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
