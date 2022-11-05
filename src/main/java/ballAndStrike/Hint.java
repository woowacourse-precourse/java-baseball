package ballAndStrike;

public class Hint {
    private Count count;
    public Hint(Count count1) {
        count = count1;
    }
    public void announceResult() {
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
