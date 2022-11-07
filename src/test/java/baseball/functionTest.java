package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class functionTest {

    @Test
    void 스트라이크_개수_세기_테스트() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(1);a.add(1);a.add(1);
        b.add(1);b.add(1);b.add(1);
        assertThat(getNumberOfStrikes(a, b)).isEqualTo(3);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(3);
        b.add(1);b.add(4);b.add(5);
        assertThat(getNumberOfStrikes(a, b)).isEqualTo(1);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(3);
        b.add(4);b.add(5);b.add(6);
        assertThat(getNumberOfStrikes(a, b)).isEqualTo(0);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(3);
        b.add(2);b.add(3);b.add(1);

        assertThat(getNumberOfStrikes(a, b)).isEqualTo(0);
    }

    @Test
    void 볼_개수_세기_테스트() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(1);a.add(2);a.add(3);
        b.add(1);b.add(2);b.add(3);
        assertThat(getNumberOfBalls(a, b)).isEqualTo(0);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(3);
        b.add(1);b.add(4);b.add(5);
        assertThat(getNumberOfBalls(a, b)).isEqualTo(0);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(3);
        b.add(2);b.add(5);b.add(6);
        assertThat(getNumberOfBalls(a, b)).isEqualTo(1);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(3);
        b.add(2);b.add(3);b.add(1);

        assertThat(getNumberOfBalls(a, b)).isEqualTo(3);

        a.clear();b.clear();
        a.add(1);a.add(2);a.add(4);
        b.add(2);b.add(1);b.add(4);

        assertThat(getNumberOfBalls(a, b)).isEqualTo(2);
    }

    @Test
    void 수_유효성_검사_기능_테스트() {
        assertThat(isValidBaseballNumber("123")).isEqualTo(true);
        assertThat(isValidBaseballNumber("1234")).isEqualTo(false);
        assertThat(isValidBaseballNumber("112")).isEqualTo(false);
        assertThat(isValidBaseballNumber("455")).isEqualTo(false);
        assertThat(isValidBaseballNumber("ABC")).isEqualTo(false);
        assertThat(isValidBaseballNumber("012")).isEqualTo(false);
        assertThat(isValidBaseballNumber("1A2")).isEqualTo(false);
        assertThat(isValidBaseballNumber("035")).isEqualTo(false);
    }

    @Test
    void 게임_결과_출력_기능_테스트() {
        assertThat(disposeOfGameResult(3, 0)).isEqualTo("3스트라이크");
        assertThat(disposeOfGameResult(2, 1)).isEqualTo("1볼 2스트라이크");
        assertThat(disposeOfGameResult(1, 2)).isEqualTo("2볼 1스트라이크");
        assertThat(disposeOfGameResult(0, 3)).isEqualTo("3볼");
        assertThat(disposeOfGameResult(0, 0)).isEqualTo("낫싱");
    }
}
