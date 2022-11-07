package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest {

    @DisplayName("랜덤으로 조건에 부합하는 숫자 문자열 검증 테스트")
    @Test
    void randomGenerateTest() {
        // 파라미터로 넣은 길이 만큼의 랜덤한 숫자 문자열 생성
        String generated = RandomNumberGenerator.generate(3);
        assertThat(generated.length()).isEqualTo(3);
        assertThat(hasNoDuplicate(generated)).isTrue();
    }

    @DisplayName("사용자의 입력값 검증클래스 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "19", "", "sample", "1s2", "511"})
    void validatePlayerInputTest(String input) {
        assertThatThrownBy(() -> {
            PlayerInputValidator.validate(input, 3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 따른 스트라이크, 볼 판별 테스트")
    @Test
    void refereeTest() {
        Referee referee = new Referee();
        referee.setStandard("123");
        referee.judge("136");
        assertThat(referee.getBall()).isEqualTo(1);
        assertThat(referee.getStrike()).isEqualTo(1);

        referee.setStandard("876");
        referee.judge("123");
        assertThat(referee.getBall()).isEqualTo(0);
        assertThat(referee.getStrike()).isEqualTo(0);

        referee.judge("876");
        assertThat(referee.getBall()).isEqualTo(0);
        assertThat(referee.getStrike()).isEqualTo(3);
    }

    // 문자열 내 중복 검사 함수
    private boolean hasNoDuplicate(String string) {
        if (string.length() < 2) {
            return true;
        }

        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            characters.add(string.charAt(i));
        }
        return string.length() == characters.size();
    }

}
