package baseball.game.domain.repository;

import baseball.game.domain.Game;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    private static final GameRepository instance=new GameRepository();
    private Game game;
    private GameRepository(){
    }
    public static GameRepository getInstance(){
        return instance;
    }
    public void setGame(List<Integer> randomNumber){
        game=new Game(randomNumber);
    }
    public Game getGame(){
        return game;
    }
}
