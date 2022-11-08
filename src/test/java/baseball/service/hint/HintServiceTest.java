package baseball.service.hint;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintServiceTest {

  private final HintService hintService = new HintService();

  @Test
  @DisplayName("3 스트라이크")
  void getHint1() {
    // given
    List<Integer> computerNumbers = List.of(4, 2, 5);
    List<Integer> playerNumbers = List.of(4, 2, 5);

    // when
    Hint hint = hintService.getHint(computerNumbers, playerNumbers);

    // then
    assertThat(hint.getBallCount()).isZero();
    assertThat(hint.getStrikeCount()).isEqualTo(3);
  }

  @Test
  @DisplayName("1 스트라이크 1볼")
  void getHint2() {
    // given
    List<Integer> computerNumbers = List.of(4, 2, 5);
    List<Integer> playerNumbers = List.of(1, 2, 4);

    // when
    Hint hint = hintService.getHint(computerNumbers, playerNumbers);

    // then
    assertThat(hint.getBallCount()).isEqualTo(1);
    assertThat(hint.getStrikeCount()).isEqualTo(1);
  }

  @Test
  @DisplayName("낫싱")
  void getHint3() {
    // given
    List<Integer> computerNumbers = List.of(4, 2, 5);
    List<Integer> playerNumbers = List.of(7, 8, 9);

    // when
    Hint hint = hintService.getHint(computerNumbers, playerNumbers);

    // then
    assertThat(hint.getBallCount()).isZero();
    assertThat(hint.getStrikeCount()).isZero();
  }

}