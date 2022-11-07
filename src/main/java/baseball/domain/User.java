package baseball.domain;

import java.util.*;

public class User {
    final static int EXCEPTION = -1;
    final static int ALL_RIGHT = 1;
    final static int ANSWER_SIZE = 3;
    private final List<Integer> userAnswer;

    public User(int answer) {
        this.userAnswer = new ArrayList<>();
        while(answer > 0) {
            userAnswer.add(answer % 10);
            answer /= 10;
        }
        Collections.reverse(userAnswer);
        validate();
    }

    public List<Integer> getUserAnswer() {
        return userAnswer;
    }

    public void validate() {
        if (answerSizeCheck(userAnswer) == EXCEPTION) {
            throw new IllegalArgumentException();
        }
        if (divideTheAnswerByOneLetter(userAnswer) == EXCEPTION) {
            throw new IllegalArgumentException();
        }
    }
    public int divideTheAnswerByOneLetter(List<Integer> answer) {
        Set<Integer> answerSet = new HashSet<>();
        for (int i = 0; i < ANSWER_SIZE; i++) {
            if (allDifferentNumberCheck(answerSet, answer.get(i)) == EXCEPTION) {
                return EXCEPTION;
            }
        }
        return ALL_RIGHT;
    }
    public int allDifferentNumberCheck(Set<Integer> answerSet, int oneLetterFromAnswer) {
        if (answerSet.contains(oneLetterFromAnswer)) {
            return EXCEPTION;
        }
        answerSet.add(oneLetterFromAnswer);
        return ALL_RIGHT;
    }

    public int answerSizeCheck(List<Integer> answer) {
        if (answer.size() == ANSWER_SIZE){
            return ALL_RIGHT;
        }
        return EXCEPTION;
    }
}
