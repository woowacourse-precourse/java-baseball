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

    @DisplayName("잘못된 플레이어 숫자 테스트")
    @Test
    void 올바르지않은_숫자_테스트(){
        final List<Integer> invalidNumbers = List.of(105, 0, 499, 676, 1, 4921);
        assertThat(invalidNumbers).filteredOn(number ->
                !Application.isNumberValid(number));
    }

    @DisplayName("스트라이크_볼_갯수 확인 테스트")
    @Test
    void 스트라이크_볼_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "971", "875", "728", "237", "281", "275", "782", "287", "2");
                    assertThat(output()).contains("낫싱", "1볼", "2볼", "3볼", "1스트라이크", "2스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                2,8,7
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
