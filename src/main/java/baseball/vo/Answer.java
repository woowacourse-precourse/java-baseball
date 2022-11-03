package baseball.vo;

import baseball.system.validation.NumberValidator;
import baseball.system.validation.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Answer {
    public static final int ANSWER_LIST_SIZE = 3;
    public static final int MIN_ANSWER_VALUE = 1;
    public static final int MAX_ANSWER_VALUE = 9;

    private final List<Integer> answer;

    public Answer(List<Integer> answer) {
        this.answer = answer;
    }

    public static Answer of(Collection<Integer> target) {
        ArrayList<Integer> targetList = new ArrayList<>(target);
        Validator<List<Integer>> validator = new NumberValidator();
        // TODO: 정적 팩토리 메소드에서 검증 클래스와의 의존성을 분리할 수 없음.
        validator.validate(targetList);

        return new Answer(targetList);
    }

    @Override
    public String toString() {
        return answer.toString();
    }

    public List<Integer> getAnswer() {
        return new ArrayList<>(answer);
    }
}
