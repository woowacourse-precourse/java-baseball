package baseball.ui;

import baseball.model.Hint;

public class HintView {
    private Hint hint;

    public void setHint(Hint hint) {
        this.hint = hint;
    }

    public void printHint(){
        System.out.println(hint);
    }

    public boolean checkWinningCondition(){
        return hint.getStrike() == 3;
    }
}
