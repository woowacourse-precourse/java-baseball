package baseball.utils;

import baseball.model.GameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class GameNumberGeneratorTest {
    @Test
    @DisplayName("서로다른 3자리 자연수 생성")
    void createGameNumber(){
        GameNumber gameNumber = GameNumberGenerator.generate();
        List<Integer> gameNumberList = getGameNumber(gameNumber);

        assertThat(gameNumberList.size()).isEqualTo(3);
        assertThat(gameNumberList).doesNotHaveDuplicates();
    }

    private List<Integer> getGameNumber(GameNumber gameNumber) {
        return IntStream.range(1, 9)
                .filter(gameNumber::contains)
                .boxed()
                .collect(Collectors.toList());
    }
}