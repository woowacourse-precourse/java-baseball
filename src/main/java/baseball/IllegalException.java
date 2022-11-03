package baseball;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class IllegalException {

    protected List<Integer> userAnswer;

    public void check(String[] inputArray) {
        isNumber(inputArray);
        isAnswerLength();
        isAllUnique();
        isNotContainZero();
    }


    private void isNumber(String[] inputArray){

        List<Integer> inputNumber = new ArrayList<>();
        try {
            for (String input : inputArray) {
                inputNumber.add(Integer.parseInt(input));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        userAnswer = inputNumber;
    }

    private void isAnswerLength(){
        if (userAnswer.size() != Game.answerLength) {
            throw new IllegalArgumentException();
        }
    }

    private void isAllUnique(){
        Set<Integer> uniqueNumber = new HashSet<>(userAnswer);
        if (userAnswer.size() != uniqueNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void isNotContainZero(){
        if (userAnswer.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

}
