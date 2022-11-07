package baseball.game;

import baseball.domain.BaseballNumberBundle;
import baseball.domain.GameResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {
    private BaseballNumberBundle victoryNumbers;
    public Computer() {
        List<Integer> randomNumbers = makeRandomNumbers();
        setVictoryNumbers(randomNumbers);
    }
    public GameResult checkAnswer(BaseballNumberBundle answer) {
        GameResult result = new GameResult();
        List<Integer> answerList = answer.getList();
        List<Integer> victoryList = victoryNumbers.getList();

        for(int i = 0; i < 3; i++) {
            if(answerList.get(i) == victoryList.get(i)) {
                result.addStrike();
            } else if(victoryList.contains(answerList.get(i))) {
                result.addBall();
            }
        }
        return result;
    }
    private List<Integer> makeRandomNumbers() {
        List<Integer> picked = new ArrayList<>();
        while(picked.size() < 3) {
            int n = Randoms.pickNumberInRange(1, 9);
            if (!isAlreadyPicked(n, picked)) {
                picked.add(n);
            }
        }
        return picked;
    }
    private boolean isAlreadyPicked(Integer number, List<Integer> picked) {
        return picked.contains(number);
    }
    public void setVictoryNumbers(List<Integer> picked) {
        victoryNumbers = new BaseballNumberBundle(picked);
    }
    public BaseballNumberBundle getVictoryNumbers() {
        return victoryNumbers;
    }
}
