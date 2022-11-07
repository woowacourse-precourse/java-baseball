package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.model.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {



    public Game initAnswer(Game game) {
        game.setNumbers(Randoms.pickUniqueNumbersInRange(1, 9, 3));

        return game;
    }

    public Game initInput(Game game, String inputStr) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < inputStr.length(); i++){
            int nextNumber = (inputStr.charAt(i)) - '0';

            if(nextNumber != ' ' - '0') {
                list.add(nextNumber);
            }
        }

        game.setNumbers(list);

        return game;
    }
}
