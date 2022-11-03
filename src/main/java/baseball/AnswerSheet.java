package baseball;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class AnswerSheet {

    public static List<Integer> userAnswer = new ArrayList<>();
    protected String[] inputArray;
    public boolean boolCorrectAnswer;

    IllegalException illegalException = new IllegalException();

    public void getUserAnswer() {
        userAnswer.clear();
        setUserAnswer();
    }

    public void guideToEnterNumber() {
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

    public boolean checkCorrectAnswer(String hint) {
        this.boolCorrectAnswer = false;
        if (hint.equals("3스트라이크")) {
            this.boolCorrectAnswer =true;
        }
        return this.boolCorrectAnswer;
    }

    public void guideAnswerCorrect() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }



}