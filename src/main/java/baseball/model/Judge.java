package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class Judge {

    private List<Baseball> attack;
    private List<Baseball> defend;


    public Judge(List<Baseball> defend) {
        this.defend = defend;
    }

    public void setDefend(List<Baseball> defend) {
        this.defend = defend;
    }

    public void setAttack(List<Baseball> attack) {
        this.attack = attack;
    }

    private boolean isStrike(int index) {
        return attack.get(index).baseballEqual(defend.get(index));
    }

    private boolean isBall(int index) {
        if (isStrike(index)) {
            return false;
        }
        return attack.get(index).baseballContain(defend);
    }

    public String judge() {

        int strike = (int) IntStream.range(0, 3).filter(this::isStrike).count();
        int ball = (int) IntStream.range(0, 3).filter(this::isBall).count();

        String result = "";
        if (ball != 0) {
            result += ball + "볼";
        }

        if (strike != 0) {
            if (!result.equals("")) {
                result += " ";
            }
            result += strike + "스트라이크";
        }

        if (result.equals("")) {
            return "낫싱";
        }

        return result;
    }

}
