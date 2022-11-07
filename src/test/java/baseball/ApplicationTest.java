package baseball;

import baseball.repository.Repository;
import baseball.service.Service;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 게임종료_후_재시작_예외값입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "345", "1", "456", "789", "12"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                3, 4, 5, 7, 8, 9
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
    void 점수_저장_반환() {
        Repository rp = new Repository(586);
        assertThat(rp.getScore()).isEqualTo(586);
    }

    @Test
    void 점수_생성후_예외사항발생X() {
        Service svc = new Service();
        Repository rp = new Repository(svc.generateScore());
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run(String.valueOf(rp.getScore()))
                ));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
