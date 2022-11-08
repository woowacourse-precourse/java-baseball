package baseball.objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    public void setUp() {
        this.computer = new Computer();
    }

    @Test
    @DisplayName("난수 값의 생성이 제대로 되는지 테스트")
    void computer_난수값_생성이_제대로_되는지_테스트() {
        // when
        List<Integer> numbers = computer.getNumbers();

        // then
        assertThat(numbers.isEmpty()).isFalse();
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.stream().allMatch(number -> number >= 1 && number <= 9))
                .isTrue();
    }

    @Test
    @DisplayName("플레이어가 넘겨준 리스트와 심판에게 넘겨져 저장된 난수 리스트가 같은지 테스트")
    void giveNumbersToReferee() {
        // given
        Rule rule = new Rule();
        Referee referee = new Referee(rule);

        // when
        computer.giveNumbersToReferee(referee);

        // then
        List<Integer> computerNumbers = computer.getNumbers();
        List<Integer> selectedNumbers = rule.getSelectedNumbers();

        assertThat(selectedNumbers).isEqualTo(computerNumbers);
        assertThat(selectedNumbers.size()).isEqualTo(computerNumbers.size());
    }
}