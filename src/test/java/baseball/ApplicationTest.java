package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("사용자가 입력한 문자가 숫자가 아닐 때 예외 테스트")
    void notNumberExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("가나다"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 동일한 숫자로 구성되어 있을 때 예외 테스트")
    void sameNumberExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("222"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("컴퓨터 숫자 입력 유효성 검사 : 3자리 일 때 테스트 성공")
    void computerNumberThreeTest() {
        List<Integer> computer = Application.getComputer();
        assertThat(computer.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("컴퓨터 숫자 입력 유효성 검사 : 3자리가 아닐 때 예외 테스트")
    void computerNumberExceptionTest() {
        List<Integer> computer = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> Application.validateComputer(computer)
                ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시작/종료 유효성 검사 : 1 또는 2를 입력하지 않았을 때 예외 테스트")
    void retryExceptionTest() {
        String answer = "3";
        assertThatThrownBy(() -> Application.validateAnswer(answer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼, 스트라이크, 낫싱 테스트")
    void ballOrStrikeTest() {
        //볼, 스트라이크 테스트
        List<Integer> computer = List.of(1, 4, 7);
        List<Integer> user = List.of(1, 7, 4);
        assertThat(Application.getMSG(computer, user)).isEqualTo("2볼 1스트라이크");

        //낫싱 테스트
        computer = List.of(1, 4, 7);
        user = List.of(2, 5, 8);
        assertThat(Application.getMSG(computer, user)).isEqualTo("낫싱");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
