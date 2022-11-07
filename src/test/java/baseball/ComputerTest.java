package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컴퓨터 숫자 생성 테스트")
class ComputerTest {
    private Computer computer = new Computer();

    @BeforeEach
    void setUp(){
        //Given
        computer = new Computer();

        //When
        computer.setNumber();
        System.out.println(computer.getNumber());
    }

    @Test
    @DisplayName("3자리 수인지 테스트")
    void check_3_digit() {
        //Then
        assertThat(computer.getNumber().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("중복있는지 테스트")
    void check_duplication() {
        //Then
        assertThat(computer.getNumber().stream()
                .distinct()
                .count()).isEqualTo(3);

    }

    @Test
    @DisplayName("숫자 범위가 1~9인지 테스트")
    void isInRange() {
        //Then
        assertThat(computer.getNumber()
                .stream()
                .allMatch(n -> n >= 1 && n <= 9)).isTrue();
    }
}