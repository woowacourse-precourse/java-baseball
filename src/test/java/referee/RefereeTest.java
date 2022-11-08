package referee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        assertThat(referee.decision(input1, answer)).isFalse();
        assertThat(referee.decision(input2, answer)).isFalse();
        assertThat(referee.decision(input3, answer)).isFalse();
        assertThat(referee.decision(input4, answer)).isTrue();
        assertThat(referee.decision(input5, answer)).isFalse();
    }

    @Test
    @DisplayName("판정한 내용을 적절한 문자열로 반환하는 지 확인")
    void build_decision_string_test() {
        String answer = "123";
        String input1 = "178"; // 1스트라이크
        String input2 = "781"; // 1볼
        String input3 = "789"; // 낫싱
        String input4 = "123"; // 게임종료
        String input5 = "132"; // 2볼 1스트라이크

        Referee referee = new Referee();

        referee.decision(input1, answer);
        assertThat(referee.getDecisionResultString())
                .isEqualTo("1스트라이크");
        referee.decision(input2, answer);
        assertThat(referee.getDecisionResultString())
                .isEqualTo("1볼 ");
        referee.decision(input3, answer);
        assertThat(referee.getDecisionResultString())
                .isEqualTo("낫싱");
        referee.decision(input4, answer);
        assertThat(referee.getDecisionResultString())
                .isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        referee.decision(input5, answer);
        assertThat(referee.getDecisionResultString())
                .isEqualTo("2볼 1스트라이크");
    }
}
