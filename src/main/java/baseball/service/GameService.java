package baseball.service;

import baseball.dto.GameResultResponseDto;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.domain.RandomNumberCreator;

import java.util.List;

public class GameService {

    private final Player player;
    private final Player computer;

    public GameService(List<Integer> playerNumbers) {
        this(playerNumbers, RandomNumberCreator.createRandomNumbers());
    }

    public GameService(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        this.player = new Player(playerNumbers);
        this.computer = new Player(computerNumbers);
    }

    public GameResultResponseDto playGame() {
        GameResult gameResult = computer.playGame(player);
        return gameResult.toResponseDto();
    }

    public void changePlayerBalls(List<Integer> newBallNumbers) {
        player.changeBalls(newBallNumbers);
    }
}
