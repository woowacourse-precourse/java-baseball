package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseballGame {

    private HashMap<String, Integer> answerMap = new HashMap<>();

    public BaseballGame(List<String> answer) {
        for (int idx=0; idx<answer.size(); idx++) {
            this.answerMap.put(answer.get(idx), idx);
        }
    }

    private BaseballGame() {
        List<String> convertedList = convertComputerList();
        for (int idx=0; idx<convertedList.size(); idx++) {
            answerMap.put(convertedList.get(idx), idx);
        }
    }

    public List<Integer> generateRandNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private List<String> convertComputerList() {
        List<Integer> computerList = generateRandNum();
        List<String> convertedList = new ArrayList<>();
        for (int separatedNumber : computerList) {
            convertedList.add(String.valueOf(separatedNumber));
        }
        return convertedList;
    }



    public int countStrike(List<String> userInput) {
        int strikeCnt = 0;
        for (int idx=0; idx<userInput.size(); idx++) {
            String separatedInput = userInput.get(idx);
            if (isSameNumber(separatedInput) && isSamePosition(separatedInput, idx)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public int countBall(List<String> userInput) {
        int BallCnt = 0;
        for (int idx=0; idx<userInput.size(); idx++) {
            String separatedInput = userInput.get(idx);
            if (isSameNumber(separatedInput) && !isSamePosition(separatedInput, idx)) {
                BallCnt++;
            }
        }
        return BallCnt;
    }

    private boolean isSameNumber(String separatedInput) {
        boolean isSameNumber = false;
        if (answerMap.get(separatedInput) != null) {
            isSameNumber = true;
        }
        return isSameNumber;
    }

    private boolean isSamePosition(String separatedInput, int position) {
        boolean isSamePosition = false;
        if (answerMap.get(separatedInput) == position) {
            isSamePosition = true;
        }
        return isSamePosition;
    }
}
