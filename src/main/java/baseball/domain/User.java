package baseball.domain;

import java.util.*;

public class User {
    final static int ANSWER_SIZE = 3;
    final static int ZERO = 0;
    final static int TEN = 10;
    private static final String EXCEPTION_MESSAGE_NOT_SAME_NUMBERS = "같은 숫자를 여러번 쓸 수 없습니다";
    private static final String EXCEPTION_MESSAGE_NOT_SAME_LENGTH = "길이가 틀립니다.";
    private final List<Integer> userAnswer;

    public User(int answer) {
        this.userAnswer = new ArrayList<>();
        while(answer > ZERO) {
            this.userAnswer.add(answer % TEN);
            answer /= TEN;
        }
        Collections.reverse(this.userAnswer);
        validate();
    }

    public List<Integer> getUserAnswer() {
        return this.userAnswer;
    }

    public void validate() {
        answerSizeCheck(this.userAnswer);
        divideTheAnswerByOneLetter();
    }

    public void divideTheAnswerByOneLetter() {
        Set<Integer> answerSet = new HashSet<>();
        for (int i = 0; i < ANSWER_SIZE; i++) {
            allDifferentNumberCheck(answerSet, userAnswer.get(i));
        }
    }

    public void allDifferentNumberCheck(Set<Integer> answerSet, int oneLetterFromAnswer) {
        if (answerSet.contains(oneLetterFromAnswer)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_SAME_NUMBERS);
        }
        answerSet.add(oneLetterFromAnswer);
    }

    public void answerSizeCheck(List<Integer> answer) {
        if (answer.size() != ANSWER_SIZE){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_SAME_LENGTH);
        }
    }
}
