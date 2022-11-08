package baseball.domain;

import domain.BaseballNumber;
import domain.BaseballNumbers;
import domain.RoundResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballNumbersTest {
    @Test
    void FailToValidateSizeIfGivenOverSize(){
        String userInput = "1234";
        assertThatThrownBy(() -> BaseballNumbers.getUserNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리의 숫자를 입력해야합니다.");
    }

    @Test
    void FailToValidateSizeIfGivenSmallSize(){
        String userInput = "56";
        assertThatThrownBy(() -> BaseballNumbers.getUserNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리의 숫자를 입력해야합니다.");
    }

    @Test
    void FailToValidateIfGivenDuplicate(){
        String userInput = "222";
        assertThatThrownBy(() -> BaseballNumbers.getUserNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3개의 숫자를 입력해야합니다.");
    }

    @Test
    void FailToCreateNumbersIfGivenNotDigit(){
        String userInput = "a2c";
        assertThatThrownBy(() -> BaseballNumbers.getUserNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    void CompareStrikeCount(){
        String input = "789";
        BaseballNumbers sourceNumbers = BaseballNumbers.getUserNumbers(input);
        RoundResult roundResult = sourceNumbers.compareTo(BaseballNumbers.getUserNumbers(input));
        assertThat(roundResult.toString()).isEqualTo("3스트라이크");
    }

    @Test
    void CompareBallCount(){
        String input = "231";
        String compareInput = "312";
        BaseballNumbers sourceNumbers = BaseballNumbers.getUserNumbers(input);
        RoundResult roundResult = sourceNumbers.compareTo(BaseballNumbers.getUserNumbers(compareInput));
        assertThat(roundResult.toString()).isEqualTo("3볼");
    }

    @Test
    void IsRandomNumbersDistinct(){
        List<BaseballNumber> randomNumbers = BaseballNumbers.getRandomNumbers();
        assertThat(randomNumbers.stream().distinct().count()).isEqualTo(3);
    }
}
