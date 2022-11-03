package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class AnswerSheet {

    public static List<Integer> userAnswer = new ArrayList<>();
    protected String[] inputArray;

    IllegalException illegalException = new IllegalException();
    Hint hint = new Hint();

    public void getUserAnswer() {

        while (true) {
            guideToEnterNumber();
            userAnswer.clear();
            setUserAnswer();

            if (hint.getHint().equals("3스트라이크")) {
                System.out.println("end");
                break;
            }
        }
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