package baseball;

import baseball.domain.BaseballResult;
import baseball.resource.GameValue;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Character> computerAnswer;

    public void createAnswer() {
        computerAnswer = new ArrayList<>();

        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            Character randomNumberChar = (char)(randomNumber + '0');

            if (!computerAnswer.contains(randomNumberChar)) {
                computerAnswer.add(randomNumberChar);
            }
        }
    }

    public BaseballResult getCalculateAnswer(String userInput) {
        BaseballResult baseballResult = new BaseballResult();

        baseballResult.setStrike(getGameStrike(userInput));
        baseballResult.setBall(getGameBall(userInput));

        return baseballResult;
    }

    public Integer getGameStrike(String userInput) {
        int resultStrike = 0;

        for(int i = 0; i < GameValue.CORRECT_LENGTH; i++) {
            if (userInput.charAt(i) == computerAnswer.get(i)) {
                resultStrike++;
            }
        }

        return resultStrike;
    }

    public Integer getGameBall(String userInput) {
        int resultBall = 0;

        for(int i = 0; i < GameValue.CORRECT_LENGTH; i++) {
            if (computerAnswer.contains(userInput.charAt(i)) && computerAnswer.get(i) != userInput.charAt(i)) {
                resultBall++;
            }
        }

        return resultBall;
    }
}
