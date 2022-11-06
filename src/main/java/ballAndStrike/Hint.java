package ballAndStrike;

public class Hint {
    private final Count count;
    public Hint(Count getCount) {
        count = getCount;
    }
    public void printHint() {
        String announceBallAndStrike = "";
        if (count.getBallNumber() == 0 && count.getStrikeNumber() == 0) {
            announceBallAndStrike += "낫싱";
        }
        if (count.getBallNumber() > 0) {
            announceBallAndStrike += count.getBallNumber() + "볼 ";
        }
        if (count.getStrikeNumber() > 0) {
            announceBallAndStrike += count.getStrikeNumber() + "스트라이크";
        }
        System.out.println(announceBallAndStrike);
    }
}
