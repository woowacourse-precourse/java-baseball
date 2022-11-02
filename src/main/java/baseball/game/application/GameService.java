package baseball.game.application;

import baseball.game.domain.repository.GameRepository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final GameService instance=new GameService();
    private final int SIZE=3;
    private final int START_RANGE=1;
    private final int END_RANGE=9;
    private final GameRepository gameRepository;
    private GameService(){
        gameRepository=GameRepository.getInstance();
    }
    public static GameService getInstance(){
        return instance;
    }
    public void run(){
        gameRepository.setGame(randomNumber());
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
