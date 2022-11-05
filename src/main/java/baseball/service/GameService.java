package baseball.service;

import java.util.List;

import baseball.model.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    public void validate(Game game){
        List<Integer> numbers = game.getNumbers();

        if(numbers.size() > 3) {
            throw new IllegalArgumentException("3개 이상의 숫자를 입력할 수 없습니다.");
        }
    }

    public Game initAnswer(Game game) {
        game.setNumbers(Randoms.pickUniqueNumbersInRange(1, 9, 3));

        return game;
    }
}
