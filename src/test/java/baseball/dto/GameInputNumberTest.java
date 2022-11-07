package baseball.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameInputNumberTest {

  @Test
  void 숫자가아닌_값이들어오면_에러발생() {
    String InputStr = "h12";

    Throwable throwable = catchThrowable(() -> new GameInputNumber(InputStr));

    assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 입력값의길이가_3이아니면_에러() {
    String InputStr = "1234";

    assertThatThrownBy(() -> new GameInputNumber(InputStr))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 중복된숫자가들어오면_에러() {
    String InputStr = "112";

    assertThatIllegalArgumentException().isThrownBy(() -> new GameInputNumber(InputStr));
  }

  @Test
  void 성공시_숫자형태의_리스트로_반환한다() {
    String InputStr = "123";

    GameInputNumber gameInputNumber = new GameInputNumber(InputStr);
    List<Integer> result = gameInputNumber.getNumbers();

    assertThat(result.size()).isEqualTo(3);
    assertThat(result).contains(1,2,3);
  }
}