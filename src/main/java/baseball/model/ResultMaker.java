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
        currentSameCount = totalSameCount;
        String strikeCountStr = getStrikeCount(computer, player, logic);
        String ballCountStr = getBallCount();
        if (ballCountStr.equals("")) {
            return strikeCountStr;
        }
        else if(strikeCountStr.equals("")) {
            return  ballCountStr;
        }
        return ballCountStr + " " + strikeCountStr;
    }

    private String getStrikeCount(List<Integer> computer, List<Integer> player, JudgeLogic logic) {
        for (int i = 0; i < computer.size(); i++) {
            if (logic.isSameNumber(computer, player, i)) {
                strikeCount++;
                currentSameCount--;
            }
            if (currentSameCount == 0) {
                break;
            }
        }
