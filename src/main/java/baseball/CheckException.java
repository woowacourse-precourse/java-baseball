package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CheckException {

    protected List<Integer> userAnswer;

    public CheckException(String[] inputArray) {
        this.userAnswer = isNumber(inputArray);
        isAnswerLength();
        isAllUnique();
        isNotContainZero();
    }

    private List<Integer> isNumber(String[] inputArray) throws IllegalArgumentException{

        List<Integer> inputNumber = new ArrayList<>();
        try {
            for (String input : inputArray) {
                inputNumber.add(Integer.parseInt(input));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return inputNumber;
    }

    private void isAnswerLength()  throws IllegalArgumentException{
        if (userAnswer.size() != Start.answerLength) {
            throw new IllegalArgumentException();
        }
    }

    private void isAllUnique() throws IllegalArgumentException{
        Set<Integer> uniqueNumber = new HashSet<>(userAnswer);
        if (userAnswer.size() != uniqueNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void isNotContainZero() throws IllegalArgumentException {
        if (userAnswer.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

}
