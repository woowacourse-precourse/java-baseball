package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumberTest {
    private static final int DIGIT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    Number number = new Number();
    @Test
    void computerNumberTest1() {
        String user = "486";
        boolean result = true;
        assertThat(number.userNumberCheck(user) == result);
    }

    @Test
    void computerNumberTest2() {
        String user = "4860";
        boolean result = false;
        assertThat(number.userNumberCheck(user) == result);
    }

    @Test
    void computerNumberTest3() {
        String user = "우테코";
        boolean result = false;
        assertThat(number.userNumberCheck(user) == result);
    }

    @Test
    void computerNumberTest4() {
        String user = "-536";
        boolean result = false;
        assertThat(number.userNumberCheck(user) == result);
    }


    @Test
    void computerNumberTest5() {
        String user = "112";
        boolean result = false;
        assertThat(number.userNumberCheck(user) == result);
    }

    @Test
    void computerNumberTest6() {
        String user = "0";
        boolean result = false;
        assertThat(number.userNumberCheck(user) == result);
    }
}