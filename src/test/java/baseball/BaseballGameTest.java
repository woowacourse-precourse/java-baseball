package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @Test
    void randomGenerateTest() {
        // 파라미터로 넣은 길이 만큼의 랜덤한 숫자 문자열 생성
        String generated = RandomNumberGenerator.generate(3);
        assertThat(generated.length()).isEqualTo(3);
        assertThat(hasNoDuplicate(generated)).isTrue();
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
