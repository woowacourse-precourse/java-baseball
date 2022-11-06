package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
public class NumberTest {

    Number number;

    @BeforeEach
    void initialize() {
        number = new Number();
    }

    @Test
    void 컴퓨터_수_조건_확인() {
        number.setRandomNumber();
        List<Integer> digits = number.getDigits();
        String target = "";
        for (Integer digit : digits) {
            target += Integer.toString(digit);
        }
        assertTrue(number.isValid(target));
    }

    @Test
    void 많은_자릿수() {
        String test = "1234";
        assertTrue(!number.isValid(test));
    }

    @Test
    void 부족한_자릿수() {
        String test = "12";
        assertTrue(!number.isValid(test));
    }

    @Test
    void 숫자_범위_확인() {
        String test = "012";
        assertTrue(!number.isValid(test));
    }

    @Test
    void 영어_포함_확인() {
        String test = "12r";
        assertTrue(!number.isValid(test));
    }

    @Test
    void 한글_포함_확인() {
        String test = "12ㄱ";
        assertTrue(!number.isValid(test));
    }

    @Test
    void 특수문자_포함_확인() {
        String test = "12-";
        assertTrue(!number.isValid(test));
    }

    @Test
    void 두자리_중복_확인() {
        String test = "112";
        assertTrue(!number.isValid(test));
    }

    @Test
    void 세자리_중복_확인() {
        String test = "222";
        assertTrue(!number.isValid(test));
    }
}
