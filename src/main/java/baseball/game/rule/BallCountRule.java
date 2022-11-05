package baseball.rule;


public class BallCountRule implements Rule {
    @Override
    public Integer check(Integer answer, Integer guess) {
        String answerString = Integer.toString(answer);
        String guessString = Integer.toString(guess);
        int count = 0;

        for (int index = 0; index < 3; index++) {
            for (int iindex = 0; iindex < 3; iindex++) {
                if (index != iindex && answerString.charAt(index) == guessString.charAt(iindex)) {
                    count++;
                }
            }
        }

        return count;
    }
}
