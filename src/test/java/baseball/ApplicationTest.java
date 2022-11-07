package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    void 랜덤값_중복_여부() {
        List<Integer> computerRandom = Application.notDuplicatedThreeRandomValue();
        Set<Integer> deduplicationRandomList = computerRandom.stream().collect(Collectors.toSet());

        assertThat(computerRandom.size()).isEqualTo(deduplicationRandomList.size());
    }

    @Test
    void  사용자_입력_예외_테스트() {
        final byte[] buf = "123".getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.askRestartOrEnd();
        });
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
