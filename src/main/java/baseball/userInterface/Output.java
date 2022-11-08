package baseball.userInterface;

import baseball.game.number.Score;

public class Output {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";

    public static void printScore(Score userScore) {
        String output = generateOutput(userScore);
        viewOutput(output);
    }

    public static String generateOutput(Score userScore) {
        StringBuilder output = new StringBuilder();

        int strike = userScore.getStrike();
        int ball = userScore.getBall();
        int out = userScore.getOut();

        judgeScore(output, strike, ball, out);

        return String.valueOf(output);
    }

    public static void judgeScore(StringBuilder output, int strike, int ball, int out) {
        if (out == 3) {
            output.append(NOTHING);
            return;
        }
        if (ball != 0) {
            output.append(ball).append(BALL);
        }
        if (strike != 0) {
            if (output.length() != 0){
                output.append(SPACE);
            }
            output.append(strike).append(STRIKE);
        }
    }

    public static void viewOutput(String output) {
        System.out.println(output);
    }
}
