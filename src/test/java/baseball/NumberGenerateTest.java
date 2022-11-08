package baseball;

import baseball.model.ComputerNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberGenerateTest {
    ComputerNumber computerNumber;
    int MAX_SIZE = 3;

    @BeforeEach
    void setUp(){
        computerNumber = new ComputerNumber();
    }

    @Test
    void 정답_제대로된_숫자_생성(){
        assertEquals(computerNumber.getBaseballNumber().length(), 3);

        for (int i = 0; i < MAX_SIZE; i++) {
            String number = computerNumber.getBaseballNumber();
            assertThat(Character.getNumericValue(number.charAt(i)))
                    .isBetween(1, 9);
        }
    }
}
