package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class ComputerTest {
    private Computer computer = new Computer();

    @Test
    void 랜덤숫자_반환() {
        assertThat(computer.randoms().size()).isEqualTo(Computer.LENGTH); // 자릿수 확인
        assertThat(new HashSet<>(computer.randoms()).size()).isEqualTo(Computer.LENGTH); // 숫자 중복 여부
        assertThat(Integer.parseInt(computer.randoms().stream().map(String::valueOf).collect(Collectors.joining())))
                .isPositive().isBetween(123, 987); // 숫자가 양수이며 세자리 숫자인지
    }

    @Test
    void 숫자변환() {
        assertThat(computer.stringToInteger("123")).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 숫자변환_에러반환체크() {
        assertThatThrownBy(() -> computer.stringToInteger(""))
                .isInstanceOf(IllegalArgumentException.class); // 미입력
        assertThatThrownBy(() -> computer.stringToInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class); // 문자
        assertThatThrownBy(() -> computer.stringToInteger("a12"))
                .isInstanceOf(IllegalArgumentException.class); // 숫자 문자 혼용
        assertThatThrownBy(() -> computer.stringToInteger("1"))
                .isInstanceOf(IllegalArgumentException.class); // 한자리수
        assertThatThrownBy(() -> computer.stringToInteger("1234"))
                .isInstanceOf(IllegalArgumentException.class); // 네자리수
        assertThatThrownBy(() -> computer.stringToInteger("332"))
                .isInstanceOf(IllegalArgumentException.class); // 숫자 중복
        assertThatCode(() -> { computer.stringToInteger("123"); }).doesNotThrowAnyException(); // 정상인 수
    }

    @Test
    void 숫자야구결과() {
        List<Integer> randoms = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(4, 5, 6)))).isFalse(); // 낫싱
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(3, 1, 2)))).isFalse(); // 3볼
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(1, 6, 2)))).isFalse(); // 1볼 1스트라이크
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(1, 4, 5)))).isFalse(); // 1스트라이크
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(1, 2, 3)))).isTrue(); // 3스트라이크
    }

    @Test
    void 재시작여부() {
        assertThat(computer.retryGame("1")).isTrue();
        assertThat(computer.retryGame("2")).isFalse();
        assertThatThrownBy(() -> computer.retryGame("3"))
                .isInstanceOf(IllegalArgumentException.class); // 1,2 외의 숫자
        assertThatThrownBy(() -> computer.retryGame("abc"))
                .isInstanceOf(IllegalArgumentException.class); // 문자
    }
}
