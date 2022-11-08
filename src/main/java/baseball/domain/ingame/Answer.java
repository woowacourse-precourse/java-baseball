package baseball.domain.ingame;

import static baseball.domain.baseballnumber.BaseballNumberListGenerator.baseballNumberListOfRandomNumbers;

import baseball.domain.baseballnumber.BaseballNumber;
import java.util.List;

public final class Answer {

    private final List<BaseballNumber> answer;

    /**
     * 해당 인스턴스는 생성 시 랜덤 숫자로 구성됩니다.
     */
    public Answer() {
        this.answer = baseballNumberListOfRandomNumbers();
    }

    public CountResult ballAndStrikeCount(Guess guess) {
        int ballCount = guess.ballCount(answer);
        int strikeCount = guess.strikeCount(answer);

        return new CountResult(ballCount, strikeCount);
    }
}
