package baseball.domain.player;

import static baseball.domain.number.Number.NUMBER_ERROR_MESSAGE;
import static baseball.domain.player.Computer.COMPUTER_NUMBER_SIZE_ERROR_MESSAGE;
import static baseball.domain.player.Computer.COMPUTER_DUPLICATE_NUMBER_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerPlayerTest {

  static Computer computerPlayer;

  @BeforeAll()
  static void computer_test_init() {
    computerPlayer = new Computer();
  }

  @Test
  @Tag("computer")
  @DisplayName("컴퓨터가 생성하는 각 자리 숫자는 1에서 9사이의 숫자입니다.")
  void computer_number_is_between_1_and_9() {
    List<Integer> numbers = computerPlayer.getNumberList();
    numbers.forEach(number -> assertTrue(1 <= number && number <= 9,
        () -> NUMBER_ERROR_MESSAGE));
  }

  @Test
  @Tag("computer")
  @DisplayName("컴퓨터가 생성하는 숫자는 세 자리 수 입니다.")
  void computer_number_is_three_digit_number() {
    assertTrue(computerPlayer.isValidComputerNumberSize(), () -> COMPUTER_NUMBER_SIZE_ERROR_MESSAGE);
  }

  @Test
  @Tag("computer")
  @DisplayName("컴퓨터가 생성하는 각 자리의 숫자는 서로 중복되지 않습니다.")
  void each_computer_number_is_distinct() {
    List<Integer> numbers = computerPlayer.getNumberList();
    List<Integer> distinctNumbers = numbers.stream().distinct().collect( Collectors.toList());
    assertEquals(numbers.size(), distinctNumbers.size(),
        () -> COMPUTER_DUPLICATE_NUMBER_ERROR_MESSAGE );
  }

  @DisplayName("컴퓨터가 생성하는 숫자가 세 자리 미만이거나 초과일 때 오류가 발생합니다.")
  @ParameterizedTest
  @MethodSource("parameterProvider1")
  @Tag("computer")
  void create_computer_number_size_error(List<Integer> numList) {
    IllegalArgumentException sizeException = assertThrows(IllegalArgumentException.class, () -> new Computer(numList));
    assertEquals(COMPUTER_NUMBER_SIZE_ERROR_MESSAGE, sizeException.getMessage());
  }

  static Stream<List<Integer>> parameterProvider1(){
    return Stream.of(
      Collections.emptyList(),
      List.of(1, 2),
      List.of(1, 2, 3, 4)
    );
  }

  @DisplayName("컴퓨터가 생성하는 숫자 중 중복의 숫자가 있을 때 오류가 발생합니다.")
  @ParameterizedTest
  @MethodSource("parameterProvider2")
  @Tag("computer")
  void create_computer_duplicate_number_error(List<Integer> numList2) {
    IllegalArgumentException duplicationException = assertThrows(IllegalArgumentException.class, () -> new Computer(numList2));
    assertEquals(COMPUTER_NUMBER_SIZE_ERROR_MESSAGE, duplicationException.getMessage());
  }

  static Stream<List<Integer>> parameterProvider2(){
    return Stream.of(
        List.of(1, 1, 2),
        List.of(1, 2, 2),
        List.of(2, 1, 2)
    );
  }
}