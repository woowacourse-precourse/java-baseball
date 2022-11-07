package baseball;

import baseball.domain.HintGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class HintGeneratorTest {
    @Test
    void case1() {
        ArrayList<Integer> strikeNumbers = new ArrayList<>();
        ArrayList<Integer> playerGuess = new ArrayList<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        int[] strikeNumbersArray = new int[]{1, 2, 3};
        int[] playerGuessArray = new int[]{2, 1, 3};

        Arrays.stream(strikeNumbersArray).forEach(strikeNumbers::add);
        Arrays.stream(playerGuessArray).forEach(playerGuess::add);

        result.put(0, 1);
        result.put(1, 2);

        assertThat(new HintGenerator(strikeNumbers).generateHint(playerGuess)).isEqualTo(result);
    }

    @Test
    void case2() {
        ArrayList<Integer> strikeNumbers = new ArrayList<>();
        ArrayList<Integer> playerGuess = new ArrayList<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        int[] strikeNumbersArray = new int[]{1, 2, 3};
        int[] playerGuessArray = new int[]{4, 5, 6};

        Arrays.stream(strikeNumbersArray).forEach(strikeNumbers::add);
        Arrays.stream(playerGuessArray).forEach(playerGuess::add);

        result.put(0, 0);
        result.put(1, 0);

        assertThat(new HintGenerator(strikeNumbers).generateHint(playerGuess)).isEqualTo(result);
    }
}
