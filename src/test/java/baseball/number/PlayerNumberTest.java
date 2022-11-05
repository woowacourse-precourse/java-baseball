package baseball.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerNumberTest {

    PlayerNumber playerNumber;
    final static String number = "123";

    @Test
    @DisplayName("입력받은 수는 정수여야한다.")
    void IsNumber() {
        playerNumber = new PlayerNumber(number);

    }
}