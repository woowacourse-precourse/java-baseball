package baseball.game;

import baseball.domain.BaseballNumberBundle;
import baseball.domain.GameResult;
import baseball.domain.GameState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    @Test
    void 서로다른_세가지숫자를_생성() {
        Computer computer = new Computer();
        List<Integer> list = computer.getVictoryNumbers().getList();
        Set<Integer> set = new HashSet<Integer>();

        for(int n : list) {
            set.add(n);
        }
        int result = set.size();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 추정_결과_확인() {
        Computer computer = new Computer();
        List<Integer> victoryNumbers = new ArrayList<>();
        victoryNumbers.add(1);
        victoryNumbers.add(2);
        victoryNumbers.add(5);
        computer.setVictoryNumbers(victoryNumbers);

        BaseballNumberBundle numbers = new BaseballNumberBundle(2, 1, 5);
        GameResult result = computer.checkAnswer(numbers);
        //System.out.println(result.getState() + "/" + result.getStrike() + "S/" + result.getBall() + "B");
        assertThat(result.getState()).isEqualTo(GameState.GOOD);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void 추정_결과_확인2() {
        Computer computer = new Computer();
        List<Integer> victoryNumbers = new ArrayList<>();
        victoryNumbers.add(1);
        victoryNumbers.add(2);
        victoryNumbers.add(5);
        computer.setVictoryNumbers(victoryNumbers);

        BaseballNumberBundle numbers = new BaseballNumberBundle(7, 8, 9);
        GameResult result = computer.checkAnswer(numbers);
        //System.out.println(result.getState() + "/" + result.getStrike() + "S/" + result.getBall() + "B");
        assertThat(result.getState()).isEqualTo(GameState.NOTHING);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void 추정_결과_확인3() {
        Computer computer = new Computer();
        List<Integer> victoryNumbers = new ArrayList<>();
        victoryNumbers.add(1);
        victoryNumbers.add(2);
        victoryNumbers.add(5);
        computer.setVictoryNumbers(victoryNumbers);

        BaseballNumberBundle numbers = new BaseballNumberBundle(5, 1, 2);
        GameResult result = computer.checkAnswer(numbers);
        //System.out.println(result.getState() + "/" + result.getStrike() + "S/" + result.getBall() + "B");
        assertThat(result.getState()).isEqualTo(GameState.GOOD);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    void 추정_결과_확인4() {
        Computer computer = new Computer();
        List<Integer> victoryNumbers = new ArrayList<>();
        victoryNumbers.add(1);
        victoryNumbers.add(2);
        victoryNumbers.add(5);
        computer.setVictoryNumbers(victoryNumbers);

        BaseballNumberBundle numbers = new BaseballNumberBundle(1, 2, 5);
        GameResult result = computer.checkAnswer(numbers);
        //System.out.println(result.getState() + "/" + result.getStrike() + "S/" + result.getBall() + "B");
        assertThat(result.getState()).isEqualTo(GameState.CORRECT);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }
}
