package baseball.game.application;

import baseball.game.domain.RandomNumber;
import baseball.game.domain.repository.GameRepository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final GameService instance=new GameService();
    private final GameRepository gameRepository;
    private GameService(){
        gameRepository=GameRepository.getInstance();
    }
    public static GameService getInstance(){
        return instance;
    }
    public void run(){
        gameRepository.setGame();
    }
}
