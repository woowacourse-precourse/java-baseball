package test;

import controller.Controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.Computer;
import model.GamePlayer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareNumbersTest {

    @Test
    void 같은_숫자() {
        Computer computer = new Computer();
        GamePlayer gamePlayer = new GamePlayer();

        computer.setRandomNumbers(new ArrayList<>(Arrays.asList(1, 2, 3)));
        computer.initCollection();
        gamePlayer.saveNumbers("123");

        HashMap<String, Integer> result = new HashMap<>();
        result.put("strike", 3);
        result.put("ball", 0);
        assertThat(Controller.compareTo(computer, gamePlayer)).isEqualTo(result);
    }

    @Test
    void 다른_숫자() {
        Computer computer = new Computer();
        GamePlayer gamePlayer = new GamePlayer();

        computer.setRandomNumbers(new ArrayList<>(Arrays.asList(1, 2, 3)));
        computer.initCollection();
        gamePlayer.saveNumbers("456");

        HashMap<String, Integer> result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);
        assertThat(Controller.compareTo(computer, gamePlayer)).isEqualTo(result);
    }

    @Test
    void 위치가_다른_숫자() {
        Computer computer = new Computer();
        GamePlayer gamePlayer = new GamePlayer();

        computer.setRandomNumbers(new ArrayList<>(Arrays.asList(1, 2, 3)));
        computer.initCollection();
        gamePlayer.saveNumbers("312");

        HashMap<String, Integer> result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 3);
        assertThat(Controller.compareTo(computer, gamePlayer)).isEqualTo(result);
    }

}
