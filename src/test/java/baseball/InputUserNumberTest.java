package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputUserNumberTest {

    @Test
    void 사용자가_숫자외의_것을_입력했을때() {

        InputUserNumber user = new InputUserNumber();

        assertThrows(IllegalArgumentException.class, () -> {
            user.setDigits("ㅅ13");
        });

    }

    @Test
    void 사용자가_3자리수_넘게_입력했을때() {
        InputUserNumber user = new InputUserNumber();

        assertThrows(IllegalArgumentException.class, () -> {
            user.setDigits("4153");
        });
    }

    @Test
    void 사용자가_중복된_숫자_입력했을때() {
        InputUserNumber user = new InputUserNumber();

        assertThrows(IllegalArgumentException.class, () -> {
            user.setDigits("113");
        });

    }


    @Test
    void 잘출력하는지_확인() {
        InputUserNumber user = new InputUserNumber();

        user.setDigits("324");

        int[] digits = user.getDigits();

        assertArrayEquals(digits, new int[]{3, 2, 4});


    }


}