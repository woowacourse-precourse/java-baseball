package baseball.computer;

import baseball.utils.appConfig.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ComputerHintGeneratorTest {

    ComputerHintGenerator computerHintGenerator = AppConfig.createComputerHintGenerator();
    List<Integer> gameComputerNumbers;

    @BeforeEach
    void initTest() {
        gameComputerNumbers = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3}));
    }

    @Test
    void 스트라이크_3인_경우_힌트_출력() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3}));
        String hint = computerHintGenerator.generateHintForInput(inputNumbers, gameComputerNumbers);
        assertThat(hint).isEqualTo("3스트라이크");
    }

    @Test
    void 스트라이크_2_경우_힌트_출력() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 9}));
        String hint = computerHintGenerator.generateHintForInput(inputNumbers, gameComputerNumbers);
        assertThat(hint).isEqualTo("2스트라이크");
    }


    @Test
    void 스트라이크_1_경우_힌트_출력() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{1, 8, 9}));
        String hint = computerHintGenerator.generateHintForInput(inputNumbers, gameComputerNumbers);
        assertThat(hint).isEqualTo("1스트라이크");
    }

    @Test
    void 스트라이크_1_볼_2_경우_힌트_출력() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{1, 3, 2}));
        String hint = computerHintGenerator.generateHintForInput(inputNumbers, gameComputerNumbers);
        assertThat(hint).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 스트라이크_1_볼_1_경우_힌트_출력() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{1, 3, 9}));
        String hint = computerHintGenerator.generateHintForInput(inputNumbers, gameComputerNumbers);
        assertThat(hint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 볼_1_경우_힌트_출력() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{8, 1, 9}));
        String hint = computerHintGenerator.generateHintForInput(inputNumbers, gameComputerNumbers);
        assertThat(hint).isEqualTo("1볼");
    }

    @Test
    void 볼_2_경우_힌트_출력() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{3, 1, 9}));
        String hint = computerHintGenerator.generateHintForInput(inputNumbers, gameComputerNumbers);
        assertThat(hint).isEqualTo("2볼");
    }

    @Test
    void 낫싱_경우_힌트_출력() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(new Integer[]{8, 7, 9}));
        String hint = computerHintGenerator.generateHintForInput(inputNumbers, gameComputerNumbers);
        assertThat(hint).isEqualTo("낫싱");
    }


}
