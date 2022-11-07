package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
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

    @Test
    void 유효한_컴퓨터번호() {
        Number computer = new Number();
        int size = computer.getComputers().size();

        assertThat(size).isEqualTo(3);
    }

    @Test
    void 유효하지않은_컴퓨터번호() {
        Number computer = new Number();
        int size = computer.getComputers().size();

        assertThat(size).isNotEqualTo(1);
    }

    @Test
    void 모든_번호가_숫자() {
        String input = "123";
        Exception.isAllNumeric(input);
        assertThat(input).isEqualTo("123");
    }

    @Test
    void 중복_제거된_리스트() {
        List<Integer> list = List.of(1, 1, 2);
        List<Integer> result = List.of(1, 2);
        assertThat(Exception.deduplicated(list)).isEqualTo(result);
    }

    @Test
    void 유효한_사용자번호길이() {
        List<Integer> list = List.of(1, 2, 3);
        boolean result = Exception.isInvalidLength(list);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 유효하지않은_사용자번호길이() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        boolean result = Exception.isInvalidLength(list);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 유효한_사용자번호범위() {
        List<Integer> list = List.of(1, 2, 3);
        boolean result = Exception.isInvalidRange(list);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 유효하지않은_사용자번호범위() {
        List<Integer> list = List.of(0, 2, 3);
        boolean result = Exception.isInvalidRange(list);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 중복된_원소가_존재() {
        List<Integer> list = List.of(1, 1, 2);
        List<Integer> deduplicated = Exception.deduplicated(list);
        boolean result = Exception.checkDuplicate(deduplicated);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 중복된_원소가_없음() {
        List<Integer> list = List.of(1, 2, 3);
        List<Integer> deduplicated = Exception.deduplicated(list);
        boolean result = Exception.checkDuplicate(deduplicated);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 유효한_게임시작_번호() {
        int input = 1;
        Exception.isInvalidInput(input);
        assertThat(input).isEqualTo(1);
    }

    @Test
    void 유효한_사용자번호() {
        List<Integer> input = List.of(1, 2, 3);
        List<Integer> result = List.of(1, 2, 3);
        Exception.handleException(input);
        assertThat(result).isEqualTo(input);
    }

    @Test
    void 스트라이크_점수_계산() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);
        Baseball baseball = new Baseball(computer, user);
        int result = baseball.getStrike();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 볼_점수_계산() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);
        Baseball baseball = new Baseball(computer, user);
        int result = baseball.getBall();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 올바른_점수_계산1() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);
        Baseball baseball = new Baseball(computer, user);
        String result = baseball.getScore();
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 올바른_점수_계산2() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(3, 2, 1);
        Baseball baseball = new Baseball(computer, user);
        String result = baseball.getScore();
        assertThat(result).isEqualTo("2볼 1스트라이크");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
