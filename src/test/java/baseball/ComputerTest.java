package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {
    @Test
    void 랜덤숫자_반환() {
        Computer computer = new Computer();
        assertThat(new HashSet<>(computer.randoms()).size()).isEqualTo(computer.randoms().size()); // 숫자 중복 여부
        assertThat(Integer.parseInt(computer.randoms().stream().map(String::valueOf).collect(Collectors.joining())))
                .isPositive().isBetween(123, 987); // 숫자가 양수이며 세자리 숫자인지
    }

    @Test
    void 게임시작문구() {
        Computer computer = new Computer();
        assertThat(computer.gameStart()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void 숫자변환() {
        Computer computer = new Computer();
        assertThat(computer.stringToInteger("123")).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 숫자변환_에러반환체크() {
        Computer computer = new Computer();
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
    void 숫자유효성체크() {
        Computer computer = new Computer();
        assertThat(computer.checkNum("")).isFalse(); // 미입력
        assertThat(computer.checkNum("abc")).isFalse(); // 문자
        assertThat(computer.checkNum("a12")).isFalse(); // 숫자 문자 혼용
        assertThat(computer.checkNum("1")).isFalse(); // 한자리수
        assertThat(computer.checkNum("1234")).isFalse(); // 네자리수
        assertThat(computer.checkNum("332")).isFalse(); // 숫자 중복
        assertThat(computer.checkNum("123")).isTrue(); // 정상인 수
    }

    @Test
    void 숫자야구결과() {
        Computer computer = new Computer();
        List<Integer> randoms = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(4, 5, 6)))).isFalse(); // 낫싱
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(3, 1, 2)))).isFalse(); // 3볼
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(1, 6, 2)))).isFalse(); // 1볼 1스트라이크
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(1, 4, 5)))).isFalse(); // 1스트라이크
        assertThat(computer.baseballGame(randoms, new ArrayList<>(Arrays.asList(1, 2, 3)))).isTrue(); // 3스트라이크
    }
}
