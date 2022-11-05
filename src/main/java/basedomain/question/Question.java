package basedomain.question;

import basedomain.answer.Answer;

public abstract class Question {

    private Answer answer;

    protected Question(Answer answer){
        this.answer = answer;
    }
}
