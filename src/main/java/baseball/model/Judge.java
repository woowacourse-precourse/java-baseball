package baseball.model;

import java.util.List;

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


}
