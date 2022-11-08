package baseball;

public class Computer {

    private final String answer;

    public Computer(String answer) {
        this.answer = answer;
    }

    public int countBall(String input) {
        int cnt = 0;

        for (int i = 0; i < input.length(); i++) {
            char curNum = input.charAt(i);

            if (answer.charAt(i) != curNum && answer.contains(String.valueOf(curNum))) {
                cnt++;
            }
        }

        return cnt;
    }

    public int countStrike(String input) {
        int cnt = 0;

        for (int i = 0; i < input.length(); i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    public String getResult(String input) {
        StringBuilder sb = new StringBuilder();

        int ballCnt = countBall(input);
        int strikeCnt = countStrike(input);

        if (ballCnt != 0) {
            sb.append(ballCnt + " 볼");
        }

        if (strikeCnt != 0) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(strikeCnt + " 스트라이크");
        }

        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        return sb.toString();
    }
}
