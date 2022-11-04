package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.PlayerNumber.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerNumberTest {

    private static PlayerNumber playerNumber;

    @BeforeEach
    private void setUp() {
        playerNumber = new PlayerNumber();
    }

    @Test
    void 문자_숫자_리스트로_변환_검사(){
        String convertString = "123";
        List<Integer> testList = new ArrayList<>(Arrays.asList(1,2,3));
        assertEquals(testList , convertNumberList(convertString));

    }


    @Test
    void 숫자_중복_검사() {
        String duplicationTestTrue = "123";
        String duplicationTestFalse = "133";
        assertTrue(duplicationCheck(duplicationTestTrue));
        assertFalse(duplicationCheck(duplicationTestFalse));
    }

    @Test
    void 숫자_길이_검사() {
        String lengthTestTrue = "123";
        String lengthTestFalse = "3";
        assertTrue(lengthCheck(lengthTestTrue));
        assertFalse(lengthCheck(lengthTestFalse));
    }

    @Test
    void 숫자_0이_있는지_검사() {
        String zeroTestTrue = "123";
        String zeroTestFalse = "012";
        assertTrue(zeroCheck(zeroTestTrue));
        assertFalse(zeroCheck(zeroTestFalse));
    }
}
