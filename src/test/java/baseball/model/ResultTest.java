package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ResultTest {
    private final List<Integer> computerNumbers = List.of(1, 3, 5);

    @Test
    @DisplayName("사용자 숫자에 따른 힌트 생성 : 같은 수가 다른 자리에 있을 경우 볼")
    void 힌트메시지_생성_1볼() {
        Result result = new Result(computerNumbers, List.of(6, 1, 9));
        assertThat(result.generateHintMessage()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("사용자 숫자에 따른 힌트 생성 : 같은 수가 같은 자리에 있을 경우 스트라이크")
    void 힌트메시지_생성_1스트라이크() {
        Result result = new Result(computerNumbers, List.of(1, 6, 9));
        assertThat(result.generateHintMessage()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("사용자 숫자에 따른 힌트 생성 : 볼, 스트라이크가 여러 개일 경우 n볼 n스트라이크")
    void 힌트메시지_생성_2볼_1스트라이크() {
        Result result = new Result(computerNumbers, List.of(5, 3, 1));
        assertThat(result.generateHintMessage()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("사용자 숫자에 따른 힌트 생성 : 같은 수가 전혀 없을 경우 낫싱")
    void 힌트메시지_생성_낫싱() {
        Result result = new Result(computerNumbers, List.of(2, 6, 8));
        assertThat(result.generateHintMessage()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("사용자 숫자에 따른 힌트 생성 : 3개의 모든 숫자를 모두 맞힐 경우 3스트라이크")
    void 힌트메시지_생성_3스트라이크() {
        Result result = new Result(computerNumbers, List.of(1, 3, 5));
        assertThat(result.generateHintMessage()).isEqualTo("3스트라이크");
    }
}