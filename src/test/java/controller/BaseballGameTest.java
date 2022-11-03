package controller;

import model.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {

    @Test
    @DisplayName("컴퓨터의 랜덤 생성 결과")
    void startGame() {
        while (Computer.getLengthOfNumber() < 3) {
            Computer.generateRandomNumber();
        }
        Integer result = 3;
        assertThat(Computer.getLengthOfNumber()).isEqualTo(3);
    }

}
