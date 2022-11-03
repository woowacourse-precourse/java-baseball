package baseball.game.domain.repository;

import baseball.game.domain.Game;
import baseball.game.domain.RandomNumber;
public class GameRepository {
    private final int SIZE=3;
    private final int START_RANGE=1;
    private final int END_RANGE=9;
    private static final GameRepository instance=new GameRepository();

    private Game game;
    private GameRepository(){}
    public Integer getSize(){
        return SIZE;
    }
    public static GameRepository getInstance(){
        return instance;
    }
    public void setGame(){
        game=new Game(new RandomNumber(SIZE,START_RANGE,END_RANGE));
    }
    public Game getGame(){
        return game;
    }
}
