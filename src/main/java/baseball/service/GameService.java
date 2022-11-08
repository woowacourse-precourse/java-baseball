package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.model.Range;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    int maxCount = Range.valueOf("MAX_COUNT").getValue();
    int minValue = Range.valueOf("MIN_VALUE").getValue();
    int maxValue = Range.valueOf("MAX_VALUE").getValue();

    public List<Integer> initAnswer() {
        List<Integer> newAnswer = new ArrayList<>();

        while (newAnswer.size() < maxCount) {
            int randomNumber = Randoms.pickNumberInRange(minValue, maxValue);
            if (!newAnswer.contains(randomNumber)) {
                newAnswer.add(randomNumber);
            }
        }

        return newAnswer;
    }

    public List<Integer> initInput(String inputStr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inputStr.length(); i++) {
            int nextNumber = (inputStr.charAt(i)) - '0';

            if (nextNumber != ' ' - '0') {
                list.add(nextNumber);
            }
        }

        return list;
    }

    public boolean compareAnswer(List<Integer> answerList, List<Integer> userList) {
        int ball = 0;
        int strike = 0;

        for (int index = 0; index < answerList.size(); index++) {
            int answerNum = answerList.get(index);
            int userNum = userList.get(index);

            if (answerNum == userNum) {
                strike++;
            }

            if (answerNum != userNum && answerList.contains(userNum)) {
                ball++;
            }
        }

        printOutput(ball, strike);

        if (strike == maxCount) {
            return true;
        }

        return false;
    }

    public void printOutput(int ball, int strike) {
        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball + "볼 ");
        }

        if (strike > 0) {
            sb.append(strike + "스트라이크");
        }

        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }
}
