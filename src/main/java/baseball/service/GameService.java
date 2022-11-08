package baseball.service;

import baseball.model.Result;
import baseball.model.Computer;
import baseball.model.Player;

import java.util.List;

public class GameService {
    private final Computer computer = Computer.getInstance();
    private final Player player = Player.getInstance();
    private List<Integer> computerNumbers;

    private GameService() { }
    private static final GameService instance = new GameService();
    public static GameService getInstance() {
        return instance;
    }

    public void refreshComputerNumbers() {
        computerNumbers = computer.generateGameNumberList();
    }

    public Result guessNumbers(String guessingNumbers) throws IllegalArgumentException {
        List<Integer> playerNumbers = player.generateGameNumberList(guessingNumbers);
        return new Result(computerNumbers, playerNumbers);
    }
}
