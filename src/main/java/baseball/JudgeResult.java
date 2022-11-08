package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class JudgeResult {
    private int strikeCount;
    private int ballCount;

    public JudgeResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private void init(){
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean isThreeStrikes(){
        boolean isThreeStrike = strikeCount == 3;
        if (!isThreeStrike){
            init();
        }

        return isThreeStrike;
    }

    public void compareTwoNumbers(int computerNumber, int playerNumber) {
        String strComputerNumber = Integer.toString(computerNumber);
        String strPlayerNumber = Integer.toString(playerNumber);
        List<Character> computerNumberList
                = strComputerNumber.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        for (int i = 0; i < 3; i++) {
            if (strPlayerNumber.charAt(i) == strComputerNumber.charAt(i)) {
                increaseStrike();
            } else if (computerNumberList.contains(strPlayerNumber.charAt(i))) {
                increaseBall();
            }
        }
    }

    public String getResultPrinted() {
        StringBuilder result = new StringBuilder();

        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        if (ballCount > 0) {
            result.append(ballCount).append("볼 ");
        }

        if (strikeCount > 0) {
            result.append(strikeCount).append("스트라이크");
        }

        return result.toString();
    }

    private void increaseStrike() {
        strikeCount++;
    }

    private void increaseBall() {
        ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
