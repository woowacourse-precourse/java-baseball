package referee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @Test
    @DisplayName("사용자 입력과 정답을 비교하여 적절한 상태를 반환하는 지 확인")
    void decision_test() {
        String answer = "123";
        String input1 = "178"; // 1스트라이크
        String input2 = "781"; // 1볼
        String input3 = "789"; // 낫싱
        String input4 = "123"; // 게임종료
        String input5 = "132"; // 2볼 1스트라이크

        Referee referee = new Referee();

        assertThat(referee.decision(input1, answer))
                .isEqualTo("1스트라이크");
        assertThat(referee.decision(input2, answer))
                .isEqualTo("1볼 ");
        assertThat(referee.decision(input3, answer))
                .isEqualTo("낫싱");
        assertThat(referee.decision(input4, answer))
                .isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        assertThat(referee.decision(input5, answer))
                .isEqualTo("2볼 1스트라이크");
    }
}
