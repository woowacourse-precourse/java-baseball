package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class GameNumberGeneratorTest {

    @Test
    @DisplayName("서로다른 3자리 자연수 생성")
    void createGameNumber(){
        Set<Integer> gameNumber = GameNumberGenerator.generate();
        assertThat(gameNumber.size()).isEqualTo(3);
        assertThat(gameNumber).doesNotHaveDuplicates();
    }
}