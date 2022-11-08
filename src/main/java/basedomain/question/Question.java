package basedomain.question;

import basedomain.answer.Answer;

public abstract class Question {

    protected Answer answer;

    protected Question(Answer answer){
        this.answer = answer;
    }

    public abstract String ask(int candidate);

    public boolean isCorrect(int candidate) {
        return answer.isCorrect(candidate);
    }
}
