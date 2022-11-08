package baseball.digit;

import baseball.score.ScoreStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.score.ScoreStatus.STRIKE;

class DigitsTest {

    @Test
    @DisplayName("모든 자리수에 ball과 strike이 몇개인지 찾는 메서드")
    void checkAllDigitsTest() {
        //given
        Digits comDigitList = new Digits(
                List.of(new Digit(0,1),
                        new Digit(1,2),
                        new Digit(2,3)
                )
        );

        Digits inputDigitList = new Digits(
                List.of(new Digit(0,1),
                        new Digit(1,2),
                        new Digit(2,3)
                )
        );
        List<ScoreStatus> output =List.of(STRIKE,STRIKE,STRIKE);

        //when
        List<ScoreStatus> scoreStatuses = comDigitList.checkAllDigits(inputDigitList);

        //then
        Assertions.assertEquals(scoreStatuses,output);
    }
}