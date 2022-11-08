package baseball.computer;

import baseball.utils.appConfig.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerGameEndCheckerTest {
    ComputerGameEndChecker computerGameEndChecker = AppConfig.createComputerGameEndChecker();
    List<Integer> gameComputerNumbers;

    @BeforeEach
    void initTest() {
        gameComputerNumbers = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3}));
    }

    @Test
    void 게임_종료_조건인_경우_false_반환() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3}));
        boolean result = computerGameEndChecker.isNotGameEnd(inputNumbers, gameComputerNumbers);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 게임_종료_조건_아닌_경우_true_반환() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{9, 8, 4}));
        boolean result = computerGameEndChecker.isNotGameEnd(inputNumbers, gameComputerNumbers);
        assertThat(result).isEqualTo(true);
    }
}
