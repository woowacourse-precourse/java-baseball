package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class AnswerSheet {

    public List<Integer> userAnswer = new ArrayList<>();
    protected String[] inputArray;

    IllegalException illegalException = new IllegalException();


    public void getUserAnswer() {
        userAnswer.clear();
        guideToEnterNumber();
        setUserAnswer();
    }

    private void guideToEnterNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void setUserAnswer() {
        illegalException.check(inputArrays());
        for (String input : inputArray) {
            userAnswer.add(Integer.parseInt(input));
        }
    }

    private String[] inputArrays() {
        inputArray = Console.readLine().split("");
        return inputArray;
    }




}