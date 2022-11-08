package baseball.service;

import baseball.vo.OneDigitNumbers;
import baseball.vo.Scoreboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameService 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameServiceTest {
    @Test
    void computer_number_추가_삭제() {
        GameService service = new GameService();
        boolean result1 = service.addComputerNumber(123);
        boolean result2 = service.deleteComputerNumber(123);

        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
    }

    @Test
    void computer_number_비교() {
        GameService service = new GameService();
        service.addComputerNumber(123);

        Scoreboard scoreboard = service.compareComputerNumberWith(123);

        assertThat(scoreboard.toList()).containsExactly(0, 3);
    }

    @Test
    void 숫자_랜덤_생성() {
        int number = GameService.pickNumber(3);
        OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(number);

        assertThat(number).isNotNegative();
        assertThat(oneDigitNumbers)
                .allMatch(num -> (num >= 1 && num <= 9))
                .doesNotHaveDuplicates()
                .hasSize(3);
    }
}
