package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MakeTest {
    //유저 숫자
    @Test
    void 길이가_다른_숫자_입력() {
        String shortNumber = "1";
        String longNumber = "1234";
        assertFalse(Application.isValidate(shortNumber));
        assertFalse(Application.isValidate(longNumber));
    }

    @Test
    void 숫자_이외의_입력() {
        String notNumber = "ABC";
        assertFalse(Application.isValidate(notNumber));
    }

    @Test
    void 숫자_공백_입력() {
        String blank = "";
        assertFalse(Application.isValidate(blank));
    }

    @Test
    void 중복된_숫자의_입력() {
        String duplicateNumber = "444";
        assertFalse(Application.isValidate(duplicateNumber));
    }
}
