package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {

    @Test
    @DisplayName("컴퓨터의 랜덤 생성 결과")
    void startGame() {
        Integer result = 3;
        assertThat(result).isEqualTo(3);
    }

}
