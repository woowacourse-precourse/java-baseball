package baseball.domain.player;

import static baseball.domain.number.Number.NUMBER_ERROR_MESSAGE;
import static baseball.domain.player.Computer.COMPUTER_NUMBER_SIZE;
import static baseball.domain.player.Computer.COMPUTER_NUMBER_SIZE_ERROR_MESSAGE;
import static baseball.domain.player.Computer.COMPUTER_DUPLICATE_NUMBER_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerPlayerTest {

  private List<Integer> numbers;

  @BeforeEach()
  void computer_test_init() {
    Computer computerPlayer = new Computer();
    numbers = computerPlayer.getNumberList();
  }

  @Test
  @Tag("computer")
  @DisplayName("컴퓨터가 생성하는 각 자리 숫자는 1에서 9사이의 숫자입니다.")
  void computer_number_is_between_1_and_9() {
    numbers.forEach(number -> assertTrue(1 <= number && number <= 9,
        () -> NUMBER_ERROR_MESSAGE));
  }

  @Test
  @Tag("computer")
  @DisplayName("컴퓨터가 생성하는 숫자는 세 자리 수 입니다.")
  void computer_number_is_three_digit_number() {
    assertEquals(COMPUTER_NUMBER_SIZE, numbers.size(),
        () -> COMPUTER_NUMBER_SIZE_ERROR_MESSAGE);
  }

  @Test
  @Tag("computer")
  @DisplayName("컴퓨터가 생성하는 각 자리의 숫자는 서로 중복되지 않습니다.")
  void each_computer_number_is_distinct() {
    List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
    assertEquals(distinctNumbers.size(), numbers.size(),
        () -> COMPUTER_DUPLICATE_NUMBER_ERROR_MESSAGE );
  }

  @DisplayName("컴퓨터가 생성하는 숫자가 세 자리 미만이거나 초과일 때 오류가 발생합니다.")
  @ParameterizedTest
  @MethodSource("parameterProvider")
  @Tag("computer")
  void create_computer_error(List<Integer> numList) {
    List<Integer> distinctNumbers = numList.stream().distinct().collect(Collectors.toList());
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Computer(distinctNumbers));
    assertEquals(COMPUTER_NUMBER_SIZE_ERROR_MESSAGE, exception.getMessage());
  }

  static Stream<List<Integer>> parameterProvider(){
    return Stream.of(
      Collections.emptyList(),
      List.of(1, 1, 2),
      List.of(1, 2, 3, 4)
    );
  }
}