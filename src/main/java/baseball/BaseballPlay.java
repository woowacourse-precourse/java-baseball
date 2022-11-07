package baseball;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BaseballPlay {
    private Map<Swing, Integer> swingResult = new TreeMap<>();

    ComputerNumber computerNumber = new ComputerNumber(ComputerNumber.generateRandomNumberSet());
    List<BallNumber> computerNumbers = computerNumber.getGameNumberSet();

    public Map<Swing, Integer> playSwing(PlayerNumber playerNumber) {
        initSwingResult();
        while (swingResult.get(Swing.STRIKE) == 3) {
            compareWithComputerNumber(playerNumber);
        }
        return swingResult;
    }

    private void compareWithComputerNumber(PlayerNumber playerNumber) {
        List<BallNumber> playerNumbers = playerNumber.getPlayerNumberSet();
        for (int i = 0; i < playerNumbers.size(); i++) {
            judgeSwingResult(i, computerNumbers, playerNumbers);
        }
    }

    private void judgeSwingResult(int index,List<BallNumber> computerNumbers, List<BallNumber> playerNumbers) {
        if (computerNumbers.contains(playerNumbers.get(index))) {
            checkStrikeBall(index, computerNumbers, playerNumbers);
        }
    }

    private void checkStrikeBall(int index, List<BallNumber> computerNumbers, List<BallNumber> playerNumbers) {
        if (computerNumbers.get(index) == playerNumbers.get(index)) {
            playStrike();
        }
        playBall();
    }

    private void playStrike() {
        swingResult.put(Swing.STRIKE, swingResult.get(Swing.STRIKE) + 1);
    }

    private void playBall() {
        swingResult.put(Swing.BALL, swingResult.get(Swing.BALL) + 1);
    }

    private void initSwingResult() {
        for (Swing result : Swing.values()) {
            swingResult.put(result, 0);
        }
    }
}