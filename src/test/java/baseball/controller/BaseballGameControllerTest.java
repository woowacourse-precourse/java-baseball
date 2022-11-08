package baseball.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.service.InputService;
import baseball.service.hint.HintService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameControllerTest {

  @Test
  @DisplayName("중복된 수가 없는 난수 생성")
  void getRandomNumbers() {
    // given
    InputService inputService = new InputService();
    HintService hintService = new HintService();

    //  when
    BaseballGameController baseballGameController = new BaseballGameController(inputService, hintService);
    List<Integer> numbers = baseballGameController.generateRandomNumbers();
    Set<Integer> numberSet = new HashSet<>(numbers);

    // then
    assertThat(numbers.size()).isEqualTo(numberSet.size());
  }
}