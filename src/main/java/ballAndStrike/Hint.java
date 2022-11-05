package ballAndStrike;

public class Hint {
    private Count count;
    private Hint hint;
    public Hint() {
        count = new Count();
    }
    public String announceResult() {
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
        return announceBallAndStrike;
    }
    public void resetResult() {
        Hint hint1 = new Hint();
    }
}
