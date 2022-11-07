package baseball.domain.game_number;

import baseball.domain.baseball_number.BaseballNumber;

import java.util.List;

import static baseball.domain.baseball_number.BaseballNumberListGenerator.baseballNumberListOfRandomNumbers;

public class Answer {

    private final List<BaseballNumber> answer;

    public Answer() {
        this.answer = baseballNumberListOfRandomNumbers();
    }

    public CountResult ballAndStrikeCount(Guess guess) {
        int ballCount = guess.ballCount(answer);
        int strikeCount = guess.strikeCount(answer);

        return new CountResult(ballCount, strikeCount);
    }

    /**
     * 테스트용 메서드 입니다.
     */
    int size() {
        return answer.size();
    }

    /**
     * 테스트용 메서드 입니다.
     */
    boolean isDuplicated() {
        int count = (int) answer.stream()
                .distinct()
                .count();
        return count != 3;
    }
}
