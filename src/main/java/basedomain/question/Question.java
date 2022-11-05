package basedomain.question;

import basedomain.answer.Answer;

public abstract class Question {

    protected Answer answer;

    protected Question(Answer answer){
        this.answer = answer;
    }

    public abstract String ask(int candidate);
}
