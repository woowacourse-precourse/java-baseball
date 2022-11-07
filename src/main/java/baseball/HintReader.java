package baseball;

import java.util.ArrayList;
import java.util.List;

public class HintReader {
    private List<Hint> hintList;
    private Long strikeCount;

    public HintReader(List<Hint> hintList) {
        this.hintList = hintList;
        strikeCount = getHintCount(Hint.STRIKE);
    }

    public boolean isThreeStrike() {
        return this.strikeCount == BaseBallNumber.BASE_BALL_NUMBER_MAX_SIZE;
    }

    public String toHintString() {
        return String.format("%s\n", String.join(" ", genHintStringList()));
    }

    private List<String> genHintStringList() {
        return genHintList(getHintCount(Hint.BALL));
    }

    private List<String> genHintList(Long ballCount) {
        if (isNothing(ballCount, this.strikeCount)) {
            return List.of(Hint.NOTHING.hintString(1L));
        }
        List<String> hintList = new ArrayList<>(List.of(Hint.BALL.hintString(ballCount), Hint.STRIKE.hintString(this.strikeCount)));
        hintList.remove("");
        return hintList;
    }

    private long getHintCount(Hint hint) {
        return this.hintList.stream().filter(h -> h.equals(hint)).count();
    }

    private boolean isNothing(Long ballCount, Long strikeCount) {
        return ballCount == 0 && strikeCount == 0;
    }
}
