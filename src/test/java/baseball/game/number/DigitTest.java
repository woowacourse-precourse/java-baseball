package baseball.game.number;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Test;

class DigitTest {
    @Test
    public void 생성자에_0_이_들어오면_예외를_던진다() {
        int digitValue = 0;
        assertThatThrownBy(()-> new Digit(digitValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 9 이하의 숫자가 아닙니다.");
    }

    @Test
    public void 생성자에_10이_들어오면_예외를_던진다() {
        int digitValue = 10;
        assertThatThrownBy(()-> new Digit(digitValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 9 이하의 숫자가 아닙니다.");
    }

    @Test
    public void 난수로_Digit_생성_테스트() {
        int randomDigitValue = Randoms.pickNumberInRange(1, 9);
        Digit randomDigit = new Digit(randomDigitValue);
        assertThat(randomDigit.digitValue).isEqualTo(randomDigitValue);
    }

    @Test
    public void value가_같으면_동등하다() {
        int randomDigitValue = Randoms.pickNumberInRange(1, 9);
        Digit digit1 = new Digit(randomDigitValue);
        Digit digit2 = new Digit(randomDigitValue);
        assertThat(digit2).isEqualTo(digit1);
    }

    @Test
    public void value가_다르면_동등하지_않다() {
        List<Integer> randomUniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 2);

        Digit digit1 = new Digit(randomUniqueNumbers.get(0));
        Digit digit2 = new Digit(randomUniqueNumbers.get(1));

        assertThat(digit2).isNotEqualTo(digit1);
    }
}