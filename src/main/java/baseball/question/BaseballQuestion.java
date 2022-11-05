package baseball.question;

import baseball.answer.BaseballAnswer;
import baseball.gametype.BaseballType;
import basedomain.question.Question;

public class BaseballQuestion extends Question {

    private BaseballType baseballGameType;

    public BaseballQuestion(BaseballType baseballGameType) {
        super(new BaseballAnswer(baseballGameType));
        this.baseballGameType = baseballGameType;
    }
}
