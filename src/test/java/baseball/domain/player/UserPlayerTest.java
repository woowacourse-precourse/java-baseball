package baseball.domain.player;

import static baseball.domain.player.User.USER_INPUT_ERROR_MESSAGE;
import static baseball.domain.player.User.USER_DUPLICATE_INPUT_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserPlayerTest {

  static User userPlayer;

  @BeforeAll()
  static void user_test_init(){
    userPlayer = new User();
  }

  @DisplayName("유저가 입력하는 숫자는 한 자리 이상 세 자리 이하, 각각은 1에서 9사이의 숫자여야 합니다.")
  @ParameterizedTest(name = "[{index}] input={0}")
  @ValueSource(strings = { "" , "0", "-1", "!@#", "1234", "120", "102"})
  @Tag("user")
  void create_user_input_error(final String input) {
    IllegalArgumentException inputException = assertThrows(IllegalArgumentException.class, () -> userPlayer.validateInputValue(input));
    assertEquals(USER_INPUT_ERROR_MESSAGE, inputException.getMessage());
  }

  @DisplayName("유저가 입력하는 각각의 숫자는 서로 중복되지 않습니다.")
  @ParameterizedTest(name = "[{index}] input={0}")
  @ValueSource(strings = { "112" , "122", "212" })
  @Tag("user")
  void create_user_duplicate_input_error(final String input) {
    IllegalArgumentException duplicationException = assertThrows(IllegalArgumentException.class, () -> userPlayer.validateInputValue(input));
    assertEquals(USER_DUPLICATE_INPUT_ERROR_MESSAGE, duplicationException.getMessage());
  }
}