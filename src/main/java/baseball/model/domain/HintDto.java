package baseball.model.domain;

import java.util.List;

public class HintDto {
    private List<Integer> hint;

    public HintDto() {}

    public List<Integer> getHint() {
        return hint;
    }

    public void setHint(List<Integer> hint) {
        this.hint = hint;
    }
}
