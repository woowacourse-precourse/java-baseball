package baseball;

import baseball.common.GameMessage;
import baseball.util.Util;

public class Computer {

    private String answer;
    public Util util;

    public Computer() {
        this.util = new Util();
        this.answer = util.createAnswerString();
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public int countBall(String input) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            char curNum = input.charAt(i);

            if (answer.contains(String.valueOf(curNum))) {
                cnt++;
            }

            if (answer.charAt(i) == curNum) {
                cnt--;
            }
        }

        return cnt;
    }

    public int countStrike(String input) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    public String getStatus(String input) {
        StringBuilder sb = new StringBuilder();

        int ballCnt = countBall(input);
        int strikeCnt = countStrike(input);

        if (ballCnt != 0) {
            sb.append(ballCnt).append(GameMessage.BALL.getValue());
        }

        if (strikeCnt != 0) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(strikeCnt).append(GameMessage.STRIKE.getValue());
        }

        if (sb.length() == 0) {
            sb.append(GameMessage.NOTING.getValue());
        }

        return sb.toString();
    }
}
