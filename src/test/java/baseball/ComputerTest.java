package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

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
}
