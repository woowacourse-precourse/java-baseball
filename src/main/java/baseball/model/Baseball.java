package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;

public class Baseball {

    private int baseball;

    public Baseball(int baseball) {
        this.baseball = baseball;
    }

    public Baseball() {
        this.baseball = pickNumberInRange(1, 9);
    }

    private int getBaseball() {
        return baseball;
    }

    public boolean baseballEqual(Baseball compareBall) {
        return baseball == compareBall.getBaseball();
    }

    public boolean baseballContain(List<Baseball> baseballs) {
        return baseballs.stream().anyMatch(this::baseballEqual);
    }


}
