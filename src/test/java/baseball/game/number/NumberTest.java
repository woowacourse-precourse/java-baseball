package baseball.game.number;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberTest {
    private List<Integer> digitNumbers;

    @BeforeEach
    public void setUp() {
        digitNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            digitNumbers.add(randomNumber);
        }
    }

    @Test
    public void digits_배열로_생성했을_때_첫번째_숫자가_일치한다() {
        Digit firstDigit = new Digit(digitNumbers.get(0));

        Number number = new Number(digitNumbers);
        assertThat(number.first).isEqualTo(firstDigit);
    }

    @Test
    public void digits_배열로_생성했을_때_두번째_숫자가_일치한다() {
        Digit secondDigit = new Digit(digitNumbers.get(1));

        Number number = new Number(digitNumbers);
        assertThat(number.second).isEqualTo(secondDigit);
    }

    @Test
    public void digits_배열로_생성했을_때_세번째_숫자가_일치한다() {
        Digit thirdDigit = new Digit(digitNumbers.get(2));

        Number number = new Number(digitNumbers);
        assertThat(number.third).isEqualTo(thirdDigit);
    }
}