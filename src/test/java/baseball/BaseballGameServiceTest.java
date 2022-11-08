package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballGameServiceTest {

    private final BaseballGameService baseballGameService = new BaseballGameService();
    private final User user = new User();

    @BeforeEach
    void init() {
        user.inputNumber("123");
    }

    @Test
    void 스트라이크_카운트_테스트() {
        user.insertAnswer(List.of(4, 1, 3));
        baseballGameService.run(user);
        assertThat(user.getStrike()).isEqualTo(1);
    }

    @Test
    void 볼_카운트_테스트() {
        user.insertAnswer(List.of(4, 1, 3));
        baseballGameService.run(user);
        assertThat(user.getBall()).isEqualTo(1);
    }

    @Test
    void 낫싱_결과_테스트() {
        user.insertAnswer(List.of(4, 5, 6));
        baseballGameService.run(user);
        String resultMessage = baseballGameService.getResultMessage(user);
        assertThat(resultMessage).isEqualTo("낫싱");
    }

    @Test
    void 볼_결과_테스트() {
        user.insertAnswer(List.of(4, 1, 6));
        baseballGameService.run(user);
        String resultMessage = baseballGameService.getResultMessage(user);
        assertThat(resultMessage).isEqualTo("1볼");
    }

    @Test
    void 스트라이크_결과_테스트() {
        user.insertAnswer(List.of(1, 5, 6));
        baseballGameService.run(user);
        String resultMessage = baseballGameService.getResultMessage(user);
        assertThat(resultMessage).isEqualTo("1스트라이크");
    }

    @Test
    void 볼_스트라이크_결과_테스트() {
        user.insertAnswer(List.of(4, 1, 3));
        baseballGameService.run(user);
        String resultMessage = baseballGameService.getResultMessage(user);
        assertThat(resultMessage).isEqualTo("1볼 1스트라이크");
    }
}
