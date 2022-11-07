package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PitchResultTest {

    private PitchResult pitchResult;

    @BeforeEach
    void setUp() {
        pitchResult = new PitchResult();
    }

    @Test
    void setResult() {
        String userInput = "712";
        List<Integer> numbers = List.of(7, 1, 3);

        pitchResult.setResult(userInput, numbers);

        assertThat(pitchResult.getStrikeCount()).isEqualTo(2);
    }
}