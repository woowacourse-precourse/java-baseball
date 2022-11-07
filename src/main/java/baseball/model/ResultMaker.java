package baseball.model;

import java.util.List;

public class ResultMaker {
    private int totalSameCount;
    private int currentSameCount;
    private int strikeCount;

    public String compare(List<Integer> computer, List<Integer> player) {

        JudgeLogic logic = new JudgeLogic();
        totalSameCount = logic.countSameNumber(computer, player);   // 총 일치하는 숫자의 갯수
        if (totalSameCount == 0) {
            return "낫싱";
        }
        int strikeCount = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (logic.isSameNumber(computer, player, i)) {
                strikeCount++;
            }
        }
        int ballCount = totalSameCount - strikeCount;
        if(ballCount == 0) {
            return  getStrikeCount(strikeCount);
        }
        else if(strikeCount==0) {
            return  getBallCount(ballCount);
        }
        return  getBallCount(ballCount) +" " + getStrikeCount(strikeCount);
    }

    private String getStrikeCount(int strikeCount) {
        String strikeCountStr = "";
        if (strikeCount != 0) {
            strikeCountStr = strikeCount + "스트라이크";
        }
        return strikeCountStr;
    }

    private String getBallCount(int ballCount) {
        String ballCountStr = "";
        if (ballCount != 0) {
            ballCountStr = ballCount + "볼";
        }
        return ballCountStr;
    }
}
