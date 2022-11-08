package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import baseball.service.InputService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballGameControllerTest {

  private final InputService inputService = new InputService();

  @Test
  void 사용자_숫자_입력테스트_성공() {
    InputStream userInput = new ByteArrayInputStream("123".getBytes());
    System.setIn(userInput);
    List<Integer> playerNumbers = inputService.getPlayerNumbers();
    Assertions.assertThat(playerNumbers).isEqualTo(List.of(1, 2, 3));
  }
}