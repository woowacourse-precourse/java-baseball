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


}
