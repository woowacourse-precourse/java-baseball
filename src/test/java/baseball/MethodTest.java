package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class MethodTest {

    @Test
    void 컴퓨터의_random_number_생성() {
        ArrayList<Integer> randomNumbers = Application.getRandomNumbers();
        assertThat(randomNumbers).hasSize(3);
        assertThat(randomNumbers).doesNotHaveDuplicates();
        for (Integer i : randomNumbers)
            assertThat(i).isBetween(1, 9);
    }

    @Test
    void ball과_strike의_개수에_따른_String_반환() {
        String result = Application.makeResultString(1, 2);
        assertThat(result).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 사용자가_잘못된_값을_입력할_경우_예외_발생() {
        assertThatThrownBy(() -> Application.checkInput("1456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값의 허용 범위를 넘습니다.");

        assertThatThrownBy(() -> Application.checkInput("454"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 수에 중복된 숫자가 있습니다.");
    }
}
