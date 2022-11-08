package baseball;

/**
 * 숫자 야구의 규칙을 수행
 */
public final class BaseballGamePolicy {

    private final String answer;
    private boolean defeated;

    public BaseballGamePolicy(final String answer) {
        this.answer = answer;
        this.defeated = false;
    }

    public boolean defeated() {
        return this.defeated;
    }

    /**
     * 숫자 야구의 규칙에 따라 볼, 스트라이크 메시지를 반환
     */
    public String scoreOf(String guess) {
        var balls = this.balls(guess);
        var strikes = this.strikes(guess);

        if (strikes == 3) {
            this.defeated = true;
        }

        return scoreMessage(balls, strikes);
    }

    private int balls(String guess) {
        int count = 0;

        if (guess.charAt(0) == this.answer.charAt(1)) {
            count++;
        }
        if (guess.charAt(0) == this.answer.charAt(2)) {
            count++;
        }
        if (guess.charAt(1) == this.answer.charAt(0)) {
            count++;
        }
        if (guess.charAt(1) == this.answer.charAt(2)) {
            count++;
        }
        if (guess.charAt(2) == this.answer.charAt(0)) {
            count++;
        }
        if (guess.charAt(2) == this.answer.charAt(1)) {
            count++;
        }

        return count;
    }

    private int strikes(String guess) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (guess.charAt(i) == this.answer.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private String scoreMessage(int balls, int strikes) {
        if (balls == 0 && strikes == 0) {
            return "낫싱";
        }

        if (strikes == 0) {
            return balls + "볼";
        }

        if (balls == 0) {
            return strikes + "스트라이크";
        }

        return balls + "볼 " + strikes + "스트라이크";
    }
}
