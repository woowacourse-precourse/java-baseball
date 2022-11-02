package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class AnswerSheet {

    private static List<Integer> userAnswer;

    public AnswerSheet() {
        guideToEnterNumber();
        CheckException checkException = new CheckException(getEnterNumber());
        this.userAnswer = setUserAnswer(checkException.userAnswer);
    }


    private void guideToEnterNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private List<Integer> getUserAnswer() {
        return this.userAnswer;
    }

    private List<Integer> setUserAnswer(List<Integer> checkedUserAnswer) {
        List<Integer> userAnswer = checkedUserAnswer;
        return userAnswer;  //아님
    }

    protected static String[] getEnterNumber() {
        String[] inputArray = Console.readLine().split("");
        return inputArray;
    }

}