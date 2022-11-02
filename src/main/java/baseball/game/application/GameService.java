package baseball.game.application;

import baseball.game.domain.repository.GameRepository;

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
    public void setGame(){

    }
}
