package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;

public class CheckException {

    protected List<Integer> userAnswer;

    public CheckException() {
        this.userAnswer = isNumber();
        isAnswerLength();
        isAllUnique();
        isNotContainZero();
    }

    private List<Integer> isNumber() throws IllegalArgumentException{

        List<Integer> inputNumber = new ArrayList<>();
        System.out.println("입력");
        try {
            String[] inputArray = Console.readLine().split("");
            for (String input : inputArray) {
                inputNumber.add(Integer.parseInt(input));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        System.out.println(inputNumber);
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
