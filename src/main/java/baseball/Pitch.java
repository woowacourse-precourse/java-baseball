package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Pitch {

    public static List<Integer> userAnswer = new ArrayList<>();
    protected String[] inputArray;
    public boolean boolCorrectAnswer;

    IllegalArgument illegalArgument = new IllegalArgument();

    public void getUserAnswer() {
        userAnswer.clear();
        setUserAnswer();
    }

    public void guideToEnterNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void setUserAnswer() {
        illegalArgument.check(inputArrays());
        for (String input : inputArray) {
            userAnswer.add(Integer.parseInt(input));
        }
    }

    private String[] inputArrays() {
        inputArray = Console.readLine().split("");
        return inputArray;
    }

    public boolean checkCorrect(String hint) {
        this.boolCorrectAnswer = false;
        if (hint.equals("3스트라이크")) {
            this.boolCorrectAnswer = true;
        }
        return this.boolCorrectAnswer;
    }

    public void guideAnswerIsCorrect() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}