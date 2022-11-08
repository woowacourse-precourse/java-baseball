package baseball.question;

import baseball.answer.BaseballAnswer;
import baseball.exception.ExceptionMessage;
import baseball.gametype.BaseballType;
import basedomain.question.Question;

public class BaseballQuestion extends Question {

    private BaseballType baseballGameType;

    public BaseballQuestion(BaseballType baseballGameType) {
        super(new BaseballAnswer(baseballGameType));
        this.baseballGameType = baseballGameType;
    }

    @Override
    public String ask(int candidate) {
        if (!isFormatCorrect(candidate)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_FORMAT_CORRECT.getMessage());
        }
        return answer.response(candidate);
    }

    private boolean isFormatCorrect(int candidate){
        return baseballGameType.isFormatCorrect(candidate);
    }
}
