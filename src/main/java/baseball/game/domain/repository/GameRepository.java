package baseball.game.domain.repository;

import baseball.game.domain.Game;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    private static final GameRepository instance=new GameRepository();
    private final int SIZE=3;
    private final int START_RANGE=1;
    private final int END_RANGE=9;
    private Game game;
    private GameRepository(){

    }

    public static GameRepository getInstance(){
        return instance;
    }
    public void setGame(){
        game=new Game(randomNumber());
    }
    public Game getGame(){
        return game;
    }

    private List<Integer> randomNumber(){
        List<Integer> randomNumber=new ArrayList<>();
        while(randomNumber.size() <SIZE) {
            int num = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
        return randomNumber;
    }
}
