package baseball.system.holder;

import baseball.vo.Answer;

public class AnswerHolder {
    private static final ThreadLocal<Answer> answerHolder = new ThreadLocal<>();

    public static Answer getAnswer() {
        return answerHolder.get();
    }

    public static void setAnswer(Answer answer) {
        answerHolder.set(answer);
    }

    public static void clearHolder() {
        answerHolder.remove();
    }
}
