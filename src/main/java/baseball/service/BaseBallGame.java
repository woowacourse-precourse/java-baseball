package baseball.service;

import baseball.repository.ComputerNumberRepository;
import baseball.repository.HintRepository;
import baseball.repository.PlayerNumberRepository;

public class BaseBallGame {
    private ComputerNumberRepository computerNumberRepository;
    private PlayerNumberRepository playerNumberRepository;
    private HintRepository hintRepository;

    public BaseBallGame() {
    }

    public void createComputerNumber() {
        computerNumberRepository = new ComputerNumberRepository();
    }

    public void createPlayerNumber(String input) {
        playerNumberRepository = new PlayerNumberRepository(input);
    }

    public void getHint() {
        hintRepository = new HintRepository();
        hintRepository.compare(computerNumberRepository, playerNumberRepository);
        hintRepository.printHint();
    }

    public boolean endGame() {
        return hintRepository.isEndGame();
    }
}