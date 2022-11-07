package baseball;

public class Referee {

    private String standard;
    private int ball;
    private int strike;

    public void setStandard(String standard) {
        ball = strike = 0;
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

    public void showResult() {
        StringBuilder stringBuilder = new StringBuilder();
        if (ball > 0) {
            stringBuilder.append(ball + "볼 ");
        }
        if (strike > 0) {
            stringBuilder.append(strike + "스트라이크");
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("낫싱");
        }
        System.out.println(stringBuilder.toString().trim());
    }

}
