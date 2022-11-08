package baseball;

import baseball.domain.BaseballResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private List<Character> computerAnswer;

    public void createAnswer() {
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

        for(int i = 0; i < 3; i++) {
            if (userInput.charAt(i) == computerAnswer.get(i)) {
                resultStrike++;
            }
        }

        return resultStrike;
    }
}
