package baseball.game.domain.repository;

import baseball.game.domain.Game;
import baseball.game.domain.RandomNumber;
public class GameRepository {
    private static final GameRepository instance=new GameRepository();
    private Game game;
    private GameRepository(){
    }
    public static GameRepository getInstance(){
        return instance;
    }
    public void setGame(){
        game=new Game(new RandomNumber());
    }
    public Game getGame(){
        return game;
    }
}
