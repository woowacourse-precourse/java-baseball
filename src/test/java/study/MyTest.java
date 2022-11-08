package study;

import baseball.Hint;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MyTest {

  @Test
  void 힌트_출력() {
    List<Integer> players1 = Arrays.asList(1,5,3);
    List<Integer> players2 = Arrays.asList(5,1,3);
    List<Integer> players3 = Arrays.asList(2,4,6);

    List<Integer> computers = Arrays.asList(1,3,5);

    Hint hint1 = new Hint(players1, computers);
    Hint hint2 = new Hint(players2, computers);
    Hint hint3 = new Hint(players3, computers);

    assertThat(hint1.getHint()).isEqualTo("2볼 1스트라이크");
    assertThat(hint2.getHint()).isEqualTo("3볼");
    assertThat(hint3.getHint()).isEqualTo("낫싱");
  }
}
