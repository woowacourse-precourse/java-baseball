package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

  String input = "123";
  List<Integer> result = Arrays.stream(input.split(""))
      .map(Integer::parseInt)
      .collect(Collectors.toList());

  @BeforeEach
  void beforeEach() {
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
  }

  @Test
  @DisplayName("리스트 형식으로 변환")
  void checkInputToList() {
    assertThat(Input.answer()).isEqualTo(result);
  }
}
