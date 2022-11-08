package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;

import java.util.List;

public class BaseballService {

    private final Computer computer;

    private final Player player;

    public BaseballService() {
        this.computer = new Computer();
        this.player = new Player(computer);
    }

    public void init() {
        computer.pickRandomNumbers();
    }

    public String checkCounts(List<Integer> numbers) {
        return player.checkCounts(numbers);
    }

    public boolean isGameFinished() {
        return player.isAllStrike();
    }
}
