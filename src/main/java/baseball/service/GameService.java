package baseball.service;

import baseball.dto.GameResultResponseDto;
import baseball.domain.Referee;
import baseball.domain.Player;
import baseball.domain.RandomNumberCreator;

import java.util.List;

public class GameService {

    private final Player player;
    private final Player computer;

    public GameService() {
        this.player = new Player();
        this.computer = new Player(RandomNumberCreator.createRandomNumbers());
    }

    public GameService(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        this.player = new Player(playerNumbers);
        this.computer = new Player(computerNumbers);
    }

    public GameResultResponseDto playGame(List<Integer> newBallNumbers) {
        player.changeBalls(newBallNumbers);
        Referee referee = player.playGame(computer);
        return referee.toResponseDto();
    }

    public void changeComputerBalls() {
        computer.changeBalls(RandomNumberCreator.createRandomNumbers());
    }
}
