package baseball;

public class Referee {

    private String standard;
    private int ball;
    private int strike;

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public void judge(String input) {
        ball = strike = 0;
        for (int i = 0; i < input.length(); i++) {
            if (standard.contains(input.substring(i, i + 1))) {
                ball++;
            }
            if (input.charAt(i) == standard.charAt(i)) {
                strike++;
            }
        }
        ball -= strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
