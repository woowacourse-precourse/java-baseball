package baseball.service;

import baseball.domain.User;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerValidator {
    final static int EXCEPTION = -1;
    final static int ALL_RIGHT = 1;
    final static int ANSWER_SIZE = 3;

    public void validate(User user) {
        if (answerSizeCheck(user.getUserAnswer()) == EXCEPTION) {
            throw new IllegalArgumentException();
        }
        if (divideTheAnswerByOneLetter(user.getUserAnswer()) == EXCEPTION) {
            throw new IllegalArgumentException();
        }
    }
    public int divideTheAnswerByOneLetter(List<Integer> answer) {
        Set<Integer> answerSet = new HashSet<>();
        for (int i = 0; i < ANSWER_SIZE; i++) {
//            if (allNumberCheck(answer.charAt(i)) == EXCEPTION) {
//                return EXCEPTION;
//            }
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

    public int allNumberCheck(char oneLetterFromAnswer) {
        try{
            int num = Character.getNumericValue(oneLetterFromAnswer);
        }
        catch(Exception e){
            return EXCEPTION;
        }
        return ALL_RIGHT;
    }
}
