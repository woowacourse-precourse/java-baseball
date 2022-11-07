package baseball.objects;

import baseball.view.service.ViewService;

import java.util.List;

public class Rule {

    private BallAndStrikeService ballAndStrikeService;
    private int strikeCount;
    private int ballCount;

    public void selectedNumber(List<Integer> computerNumbers) {
        this.ballAndStrikeService = new BallAndStrikeService(computerNumbers);
    }

    public ViewService answerNumber(List<Integer> target) {
        for (int index = 0; index < target.size(); index++) {
            Integer value = target.get(index);
            contains(index, value);
        }

        ViewService gameMessage = new ViewService(strikeCount, ballCount);
        clear();
        return gameMessage;
    }

    private void clear() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private void contains(int index, Integer value) {
        if (ballAndStrikeService.containsExactly(value, index)) {
            strikeCount += 1;
            return;
        }

        if (ballAndStrikeService.contains(value)) {
            ballCount += 1;
        }
    }

    public List<Integer> getSelectedNumbers() {
        return ballAndStrikeService.getSelectedNumbers();
    }
}
