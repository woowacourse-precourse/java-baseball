package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {

    public List<Integer> getGameResult(List<Integer> userInput, List<Integer> answerNumbers) {
        Integer strike = strikeChecker(userInput, answerNumbers);
        Integer ball = ballChecker(userInput, answerNumbers);

        List<Integer> gameResult = new ArrayList<>();

        gameResult.add(strike);
        gameResult.add(ball);

        return gameResult;
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

    private Integer strikeChecker(List<Integer> userInput, List<Integer> answerNumbers) {
        Integer strike = 0;

        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i) == answerNumbers.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    private Integer ballChecker(List<Integer> userInput, List<Integer> answerNumbers) {
        Integer ball = 0;

        int strikeAndBall = (int)userInput.stream()
                .filter(s -> answerNumbers.contains(s))
                .count();

        ball = strikeAndBall - strikeChecker(userInput, answerNumbers);

        return ball;
    }
}
