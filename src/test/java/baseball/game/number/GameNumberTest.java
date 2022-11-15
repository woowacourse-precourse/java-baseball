package baseball.game.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameNumberTest {
    private List<Integer> digitNumbers;

    @BeforeEach
    public void setUp() {
        digitNumbers = new ArrayList<>();
        while(digitNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digitNumbers.contains(randomNumber)) {
                digitNumbers.add(randomNumber);
            }
        }
    }

    @Test
    public void digits_배열로_생성했을_때_첫번째_숫자가_일치한다() {
        Digit firstDigit = new Digit(digitNumbers.get(0));

        GameNumber number = new GameNumber(digitNumbers);
        assertThat(number.first).isEqualTo(firstDigit);
    }

    @Test
    public void digits_배열로_생성했을_때_두번째_숫자가_일치한다() {
        Digit secondDigit = new Digit(digitNumbers.get(1));

        GameNumber number = new GameNumber(digitNumbers);
        assertThat(number.second).isEqualTo(secondDigit);
    }

    @Test
    public void digits_배열로_생성했을_때_세번째_숫자가_일치한다() {
        Digit thirdDigit = new Digit(digitNumbers.get(2));

        GameNumber number = new GameNumber(digitNumbers);
        assertThat(number.third).isEqualTo(thirdDigit);
    }

    @Test
    public void 백보다_작은_수가_들어오면_예외를_던진다() {
        int invalidNumber = Randoms.pickNumberInRange(0, 99);
        assertThatThrownBy(() -> GameNumber.of(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 수가 아닙니다.");
    }

    @Test
    public void 네자릿_수가_들어오면_예외를_던진다() {
        int invalidNumber = Randoms.pickNumberInRange(1000, 9999);
        assertThatThrownBy(() -> GameNumber.of(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 수가 아닙니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 인자로 받으면 예외를 던진다.")
    public void throwExceptionWhenStringContainsNaN() {
        assertThatThrownBy(() -> GameNumber.of("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
    }

    private int convertToNumber(List<Integer> digitNumbers) {
        return digitNumbers.get(0)*100 + digitNumbers.get(1)*10 + digitNumbers.get(2);
    }

    @Test
    public void 세자리_수로_생성했을_때_첫번째_숫자가_일치한다() {
        int randomDigitNumber = convertToNumber(digitNumbers);
        GameNumber number = GameNumber.of(randomDigitNumber);

        Digit firstDigit = new Digit(digitNumbers.get(0));
        assertThat(number.first).isEqualTo(firstDigit);
    }

    @Test
    public void 세자리_수로_생성했을_때_두번째_숫자가_일치한다() {
        int randomDigitNumber = convertToNumber(digitNumbers);
        GameNumber number = GameNumber.of(randomDigitNumber);

        Digit secondDigit = new Digit(digitNumbers.get(1));
        assertThat(number.second).isEqualTo(secondDigit);
    }

    @Test
    public void 세자리_수로_생성했을_때_세번째_숫자가_일치한다() {
        int randomDigitNumber = convertToNumber(digitNumbers);
        GameNumber number = GameNumber.of(randomDigitNumber);

        Digit thirdDigit = new Digit(digitNumbers.get(2));
        assertThat(number.third).isEqualTo(thirdDigit);
    }

    @Test
    public void 범위보다_작은_수가_들어오면_예외를_던진다() {
        int numberlessThanRange = Randoms.pickNumberInRange(1, 99);
        assertThatThrownBy(()-> GameNumber.of(numberlessThanRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 수가 아닙니다.");
    }

    @Test
    public void 범위보다_큰_수가_들어오면_예외를_던진다() {
        int numberlessThanRange = Randoms.pickNumberInRange(1000, 9999);
        assertThatThrownBy(()-> GameNumber.of(numberlessThanRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 수가 아닙니다.");
    }

    private int convertDuplicateDigitNumber(List<Integer> digitNumbers) {
        return digitNumbers.get(0) * 100 + digitNumbers.get(1)*10 + digitNumbers.get(1);
    }

    @Test
    public void 같은_수가_포함된_수가_들어오면_예외를_던진다() {
        int randomButNotUniqueDigitNumber = convertDuplicateDigitNumber(digitNumbers);
        assertThatThrownBy(()-> GameNumber.of(randomButNotUniqueDigitNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3자리 수가 아닙니다.");
    }

    @Test
    public void 생성시_숫자가_같으면_동등하다() {
        List<Integer> randomDigits = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        int convertedNumber = convertToNumber(randomDigits);

        GameNumber number1 = new GameNumber(randomDigits);
        GameNumber number2 = GameNumber.of(convertedNumber);

        assertThat(number2).isEqualTo(number1);
    }

    @Test
    public void 생성시_숫자가_다르면_동등하지_않다() {
        List<Integer> randomDigits = Randoms.pickUniqueNumbersInRange(1, 9, 6);
        int firstConvertedNumber = convertToNumber(randomDigits.subList(0, 3));
        int secondConvertedNumber = convertToNumber(randomDigits.subList(3, 6));

        GameNumber number1 = GameNumber.of(firstConvertedNumber);
        GameNumber number2 = GameNumber.of(secondConvertedNumber);

        assertThat(number2).isNotEqualTo(number1);
    }


}