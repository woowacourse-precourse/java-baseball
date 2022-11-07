package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.model.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    public void validate(Game game){
        List<Integer> numbers = game.getNumbers();

        if(numbers.size() < 3) {
            throw new IllegalArgumentException("3개 미만의 숫자를 입력할 수 없습니다.");
        }

        if(numbers.size() > 3) {
            throw new IllegalArgumentException("3개 초과의 숫자를 입력할 수 없습니다.");
        }

        for(int num : game.getNumbers()){
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("1에서 9 사이의 숫자만 입력할 수 있습니다.");
            }
        }
    }

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
