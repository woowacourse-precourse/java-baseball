package baseball;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class methodTest {

    @Test
    void 볼_스트라이크_계산_1() {
        List<Integer> computerList = List.of(1, 2, 3);
        List<Integer> userList = List.of(1, 2, 3);
        String result = Application.countBallStrike(computerList, userList);
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 볼_스트라이크_계산_2() {
        List<Integer> computerList = List.of(1, 2, 3);
        List<Integer> userList = List.of(1, 3, 2);
        String result = Application.countBallStrike(computerList, userList);
        assertThat(result).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 볼_스트라이크_계산_3() {
        List<Integer> computerList = List.of(1, 2, 3);
        List<Integer> userList = List.of(4, 5, 6);
        String result = Application.countBallStrike(computerList, userList);
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void 게임_숫자_입력_유효_확인_1() {
        boolean result = Application.checkNumberIsValid("123");
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 게임_숫자_입력_유효_확인_2() {
        assertThatThrownBy(() -> Application.checkNumberIsValid("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_숫자_입력_유효_확인_3() {
        assertThatThrownBy(() -> Application.checkNumberIsValid("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_리스트_변환() {
        assertThat(Application.changeStringToList("123")).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 재시작_종료_입력_유효_확인_1() {
        assertThat(Application.checkInputRestartOrExitIsValid("1")).isEqualTo("1");
    }

    @Test
    void 재시작_종료_입력_유효_확인_2() {
        assertThatThrownBy(() -> Application.checkInputRestartOrExitIsValid("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
