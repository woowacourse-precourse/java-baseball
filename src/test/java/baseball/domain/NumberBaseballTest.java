package baseball.domain;

import baseball.utils.Checker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballTest extends NumberBaseball{
    private NumberBaseball numberBaseball;
    @BeforeEach
    void setup() {
        numberBaseball = new NumberBaseball();
    }

    @Test
    void testComputerHasDifferent3Numbers() {
        assertThat(Checker.hasDifferentNumbers(numberBaseball.getComputerNumber()))
                .isTrue();
    }

    @Test
    void testCompareNumbersAfterRead() {
        String inputString = "123";
        assertThrows(IllegalArgumentException.class, () -> {
            Checker.validateUserNumber("1234");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Checker.validateUserNumber("133");
        });
        numberBaseball.compareComputerNumberWith(inputString);
        assertThat(numberBaseball.getGameResult().length() > 0).isTrue();
    }

    @Test
    void testCountStrike() {
        numberBaseball.compareComputerNumberWith(numberBaseball.getComputerNumber());
        assertThat(numberBaseball.getStrike()).isEqualTo(3);
    }

    @Test
    void testCountBall() {
        numberBaseball.setComputerNumber("123");
        numberBaseball.compareComputerNumberWith("215");
        assertThat(numberBaseball.getBall()).isEqualTo(2);
    }

    @Test
    void testShowGameResult() {
        numberBaseball.setComputerNumber("123");

        numberBaseball.compareComputerNumberWith("123");
        assertThat(numberBaseball.getGameResult())
                .isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        numberBaseball.compareComputerNumberWith("132");
        assertThat(numberBaseball.getGameResult())
                .isEqualTo("2볼 1스트라이크\n");

        numberBaseball.compareComputerNumberWith("789");
        assertThat(numberBaseball.getGameResult())
                .isEqualTo("낫싱");

        numberBaseball.compareComputerNumberWith("315");
        assertThat(numberBaseball.getGameResult()).isEqualTo("2볼 ");
    }
}