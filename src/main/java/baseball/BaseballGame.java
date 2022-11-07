package baseball;

import java.util.List;

public class BaseballGame {

    private int ballCondition;
    private int strikeCondition;
    private boolean threeStrike;

    public BaseballGame() {
        ballCondition = 0;
        strikeCondition = 0;
        threeStrike = false;
    }

    public int getBallCondition() {
        return ballCondition;
    }

    public int getStrikeCondition() {
        return strikeCondition;
    }

    public boolean isThreeStrike() {
        return threeStrike;
    }

    //결과 check
    public void conditionCheck(List<Integer> computer, List<Integer> player) {
        ballCondition = 0;
        strikeCondition = 0;

        for (int i = 0; i < player.size(); i++) {
            if (player.get(i) == computer.get(i)) {
                strikeCondition += 1;
            } else if (computer.contains(player.get(i))) {
                ballCondition += 1;
            }
        }

        if (strikeCondition == 3) {
            threeStrike = true;
        }
    }

    public String printCondition() {
        String result = "";

        if (ballCondition != 0) {
            result += ballCondition + "볼 ";
        }
        if (strikeCondition != 0) {
            result += strikeCondition + "스트라이크";
        }
        if (ballCondition == 0 && strikeCondition == 0) {
            result += "낫싱";
        }

        System.out.println(result);
        return result;
    }
}
