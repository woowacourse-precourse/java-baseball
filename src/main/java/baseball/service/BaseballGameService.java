package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {

    public List<Integer> getGameResult(List<Integer> userInput, List<Integer> answerNumbers) {
        return null;
    }

    public List<Integer> getRandomNumber() {
        List<Integer> gameResultList = new ArrayList<>();
        while (gameResultList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!gameResultList.contains(randomNumber)) {
                gameResultList.add(randomNumber);
            }
        }
        return gameResultList;

    }
}
